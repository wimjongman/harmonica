package com.weltevree.harmonica.internal;

/*
 * @(#)CapturePlayback.java	1.11	99/12/03
 *
 * Copyright (c) 1999 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Sun grants you ("Licensee") a non-exclusive, royalty free, license to use,
 * modify and redistribute this software in source and binary code form,
 * provided that i) this copyright notice and license appear on all copies of
 * the software; and ii) Licensee does not utilize the software in a manner
 * which is disparaging to Sun.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING ANY
 * IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR
 * NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
 * OR DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS
 * LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
 * INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER
 * CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF
 * OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES.
 *
 * This software is not designed or intended for use in on-line control of
 * aircraft, air traffic, aircraft navigation or aircraft communications; or in
 * the design, construction, operation or maintenance of any nuclear
 * facility. Licensee represents and warrants that it will not use or
 * redistribute the Software for such purposes.
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

/**
 * Capture/Playback sample. Record audio in different formats and then playback
 * the recorded audio. The captured audio can be saved either as a WAVE, AU or
 * AIFF. Or load an audio file for streaming playback.
 * 
 * @version @(#)CapturePlayback.java 1.11 99/12/03
 * @author Brian Lichtenwalter
 */
public class CapturePlayback2 {

	final int bufSize = 16384;

	Capture capture = new Capture();
	Playback playback = new Playback();

	String fileName = "untitled";
	String errStr;
	double duration, seconds;
	File file;

	ByteArrayOutputStream stream;

	public CapturePlayback2() {

	}

	public Capture getCapture() {
		return capture;
	}

	public Playback getPlayback() {
		return playback;
	}

	public AudioFormat getFormat() {

		AudioFormat.Encoding encoding = AudioFormat.Encoding.ULAW;
		// float rate = Float.valueOf((String) v.get(1)).floatValue();
		// int sampleSize = Integer.valueOf((String) v.get(2)).intValue();
		// boolean bigEndian = ((String) v.get(4)).startsWith("big");

		float rate = 44100;
		int sampleSize = 16;
		boolean bigEndian = true;
		int channels = 1;

		String encString = "linear";
		String signedString = "signed";
		if (encString.equals("linear")) {
			if (signedString.equals("signed")) {
				encoding = AudioFormat.Encoding.PCM_SIGNED;
			} else {
				encoding = AudioFormat.Encoding.PCM_UNSIGNED;
			}
		} else if (encString.equals("alaw")) {
			encoding = AudioFormat.Encoding.ALAW;
		}

		return new AudioFormat(encoding, rate, sampleSize, channels,
				(sampleSize / 8) * channels, rate, bigEndian);
	}

	private void reportStatus(String string) {
		System.out.println(string);
	}

	/**
	 * Write data to the OutputChannel.
	 */
	public class Playback implements Runnable {

		SourceDataLine line;
		Thread thread;

		public void start() {
			errStr = null;
			thread = new Thread(this);
			thread.setName("Playback");
			thread.start();
		}

		public void stop() {
			thread = null;
		}

		private void shutDown(String message) {
			if ((errStr = message) != null) {
				System.err.println(errStr);
			}
			if (thread != null) {
				thread = null;
			}
		}

		public void run() {

			// load bytes into the audio input stream for playback
			AudioFormat format = getFormat();
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
			int frameSizeInBytes = format.getFrameSize();
			byte audioBytes[] = stream.toByteArray();
			stream.reset();
			ByteArrayInputStream bais = new ByteArrayInputStream(audioBytes);
			AudioInputStream audioInputStream = new AudioInputStream(bais,
					format, audioBytes.length / frameSizeInBytes);

			long milliseconds = (long) ((audioInputStream.getFrameLength() * 1000) / format
					.getFrameRate());
			duration = milliseconds / 1000.0;

			try {
				audioInputStream.reset();
			} catch (Exception ex) {
				ex.printStackTrace();
				return;
			}

			AudioInputStream playbackInputStream = AudioSystem
					.getAudioInputStream(format, audioInputStream);

			if (playbackInputStream == null) {
				shutDown("Unable to convert stream of format "
						+ audioInputStream + " to format " + format);
				return;
			}

			// define the required attributes for our line,
			// and make sure a compatible line is supported.
			info = new DataLine.Info(SourceDataLine.class, format);
			if (!AudioSystem.isLineSupported(info)) {
				shutDown("Line matching " + info + " not supported.");
				return;
			}

			// get and open the source data line for playback.

			try {
				line = (SourceDataLine) AudioSystem.getLine(info);
				line.open(format, bufSize);
			} catch (LineUnavailableException ex) {
				shutDown("Unable to open the line: " + ex);
				return;
			}

			// play back the captured audio data

			int bufferLengthInFrames = line.getBufferSize() / 8;
			int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
			byte[] data = new byte[bufferLengthInBytes];
			int numBytesRead = 0;

			// start the source data line
			line.start();

			while (thread != null) {
				try {
					if ((numBytesRead = playbackInputStream.read(data)) == -1) {
						break;
					}
					int numBytesRemaining = numBytesRead;
					while (numBytesRemaining > 0) {
						numBytesRemaining -= line.write(data, 0,
								numBytesRemaining);
					}
				} catch (Exception e) {
					shutDown("Error during playback: " + e);
					break;
				}
			}
			// we reached the end of the stream. let the data play out, then
			// stop and close the line.
			if (thread != null) {
				line.drain();
			}
			line.stop();
			line.close();
			line = null;
			shutDown(null);
		}
	} // End class Playback

	/**
	 * Reads data from the input channel and writes to the output stream
	 */
	public class Capture implements Runnable {

		TargetDataLine line;
		Thread thread;

		public void start() {
			errStr = null;
			thread = new Thread(this);
			thread.setName("Capture");
			thread.start();
		}

		public void stop() {
			thread = null;
		}

		public void flush() {
			Debug.log("flushing " + line.available());
			line.flush();
		}

		private void shutDown(String message) {
			if ((errStr = message) != null && thread != null) {
				thread = null;
				System.err.println(errStr);
			}
		}

		public void run() {

			// duration = 0;
			// audioInputStream = null;

			// define the required attributes for our line,
			// and make sure a compatible line is supported.

			AudioFormat format = getFormat();
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

			if (!AudioSystem.isLineSupported(info)) {
				shutDown("Line matching " + info + " not supported.");
				return;
			}

			// get and open the target data line for capture.

			try {
				line = (TargetDataLine) AudioSystem.getLine(info);
				line.open(format, line.getBufferSize());
			} catch (LineUnavailableException ex) {
				shutDown("Unable to open the line: " + ex);
				return;
			} catch (SecurityException ex) {
				shutDown(ex.toString());
				return;
			} catch (Exception ex) {
				shutDown(ex.toString());
				return;
			}

			// play back the captured audio data
			stream = new ByteArrayOutputStream();
			int frameSizeInBytes = format.getFrameSize();
			int bufferLengthInFrames = line.getBufferSize() / 8;
			int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
			byte[] data = new byte[bufferLengthInBytes];
			int numBytesRead;

			line.start();

			while (thread != null) {
				if ((numBytesRead = line.read(data, 0, bufferLengthInBytes)) == -1) {
					break;
				}
				stream.write(data, 0, numBytesRead);
			}

			// we reached the end of the stream. stop and close the line.
			line.stop();
			line.close();
			line = null;

			// stop and close the output stream
			try {
				stream.flush();
				stream.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}

		public void pause() {
			line.stop();
		}

		public void resume() {
			line.start();
		}

		public byte[] getData() {

			int available = line.available();
			if (available == 0)
				return new byte[0];

			AudioFormat format = getFormat();
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
			int frameSizeInBytes = format.getFrameSize();
			return stream.toByteArray();

		}
	}
}
