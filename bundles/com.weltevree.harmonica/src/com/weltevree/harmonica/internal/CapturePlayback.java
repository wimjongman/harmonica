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


import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Line2D;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Enumeration;
import java.util.Vector;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;




/**
 *  Capture/Playback sample.  Record audio in different formats
 *  and then playback the recorded audio.  The captured audio can 
 *  be saved either as a WAVE, AU or AIFF.  Or load an audio file
 *  for streaming playback.
 *
 * @version @(#)CapturePlayback.java	1.11	99/12/03
 * @author Brian Lichtenwalter  
 */
public class CapturePlayback {

    final int bufSize = 16384;

    Capture capture = new Capture();
    Playback playback = new Playback();

    AudioInputStream audioInputStream;
    SamplingGraph samplingGraph;

    String fileName = "untitled";
    String errStr;
    double duration, seconds;
    File file;
    Vector lines = new Vector();



    public CapturePlayback() {
 
    }


    public void open() { }


    public void close() {
    }




 

    public void createAudioInputStream(File file, boolean updateComponents) {
        if (file != null && file.isFile()) {
            try {
                this.file = file;
                errStr = null;
                audioInputStream = AudioSystem.getAudioInputStream(file);
                fileName = file.getName();
                long milliseconds = (long)((audioInputStream.getFrameLength() * 1000) / audioInputStream.getFormat().getFrameRate());
                duration = milliseconds / 1000.0;
                if (updateComponents) {
                    samplingGraph.createWaveForm(null);
                }
            } catch (Exception ex) { 
                reportStatus(ex.toString());
            }
        } else {
            reportStatus("Audio file required.");
        }
    }


    public void saveToFile(String name, AudioFileFormat.Type fileType) {

        if (audioInputStream == null) {
            reportStatus("No loaded audio to save");
            return;
        } else if (file != null) {
            createAudioInputStream(file, false);
        }

        // reset to the beginnning of the captured data
        try {
            audioInputStream.reset();
        } catch (Exception e) { 
            reportStatus("Unable to reset stream " + e);
            return;
        }

        File file = new File(fileName = name);
        try {
            if (AudioSystem.write(audioInputStream, fileType, file) == -1) {
                throw new IOException("Problems writing to file");
            }
        } catch (Exception ex) { reportStatus(ex.toString()); }
        samplingGraph.repaint();
    }
        

    private void reportStatus(String msg) {
        if ((errStr = msg) != null) {
            System.out.println(errStr);
            samplingGraph.repaint();
        }
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
                samplingGraph.repaint();
            }
            if (thread != null) {
                thread = null;
                samplingGraph.stop();
            } 
        }

        public void run() {

            // reload the file if loaded by file
            if (file != null) {
                createAudioInputStream(file, false);
            }

            // make sure we have something to play
            if (audioInputStream == null) {
                shutDown("No loaded audio to play back");
                return;
            }
            // reset to the beginnning of the stream
            try {
                audioInputStream.reset();
            } catch (Exception e) {
                shutDown("Unable to reset the stream\n" + e);
                return;
            }

            // get an AudioInputStream of the desired format for playback
            AudioFormat format = formatControls.getFormat();
            AudioInputStream playbackInputStream = AudioSystem.getAudioInputStream(format, audioInputStream);
                        
            if (playbackInputStream == null) {
                shutDown("Unable to convert stream of format " + audioInputStream + " to format " + format);
                return;
            }

            // define the required attributes for our line, 
            // and make sure a compatible line is supported.

            DataLine.Info info = new DataLine.Info(SourceDataLine.class, 
                format);
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

            int frameSizeInBytes = format.getFrameSize();
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
                    while (numBytesRemaining > 0 ) {
                        numBytesRemaining -= line.write(data, 0, numBytesRemaining);
                    }
                } catch (Exception e) {
                    shutDown("Error during playback: " + e);
                    break;
                }
            }
            // we reached the end of the stream.  let the data play out, then
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
    class Capture implements Runnable {

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
        
        private void shutDown(String message) {
            if ((errStr = message) != null && thread != null) {
                thread = null;
                samplingGraph.stop();
                loadB.setEnabled(true);
                playB.setEnabled(true);
                pausB.setEnabled(false);
                auB.setEnabled(true);
                aiffB.setEnabled(true);
                waveB.setEnabled(true);
                captB.setText("Record");
                System.err.println(errStr);
                samplingGraph.repaint();
            }
        }

        public void run() {

            duration = 0;
            audioInputStream = null;
            
            // define the required attributes for our line, 
            // and make sure a compatible line is supported.

            AudioFormat format = formatControls.getFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, 
                format);
                        
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
                JavaSound.showInfoDialog();
                return;
            } catch (Exception ex) { 
                shutDown(ex.toString());
                return;
            }

            // play back the captured audio data
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int frameSizeInBytes = format.getFrameSize();
            int bufferLengthInFrames = line.getBufferSize() / 8;
            int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
            byte[] data = new byte[bufferLengthInBytes];
            int numBytesRead;
            
            line.start();

            while (thread != null) {
                if((numBytesRead = line.read(data, 0, bufferLengthInBytes)) == -1) {
                    break;
                }
                out.write(data, 0, numBytesRead);
            }

            // we reached the end of the stream.  stop and close the line.
            line.stop();
            line.close();
            line = null;

            // stop and close the output stream
            try {
                out.flush();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // load bytes into the audio input stream for playback

            byte audioBytes[] = out.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(audioBytes);
            audioInputStream = new AudioInputStream(bais, format, audioBytes.length / frameSizeInBytes);

            long milliseconds = (long)((audioInputStream.getFrameLength() * 1000) / format.getFrameRate());
            duration = milliseconds / 1000.0;

            try {
                audioInputStream.reset();
            } catch (Exception ex) { 
                ex.printStackTrace(); 
                return;
            }

            samplingGraph.createWaveForm(audioBytes);
        }
    } // End class Capture
 

    /**
     * Controls for the AudioFormat.
     */
    class FormatControls extends JPanel {
    
        Vector groups = new Vector();
        JToggleButton linrB, ulawB, alawB, rate8B, rate11B, rate16B, rate22B, rate44B;
        JToggleButton size8B, size16B, signB, unsignB, litB, bigB, monoB,sterB;
    
        public FormatControls() {
            setLayout(new GridLayout(0,1));
            EmptyBorder eb = new EmptyBorder(0,0,0,5);
            BevelBorder bb = new BevelBorder(BevelBorder.LOWERED);
            CompoundBorder cb = new CompoundBorder(eb, bb);
            setBorder(new CompoundBorder(cb, new EmptyBorder(8,5,5,5)));
            JPanel p1 = new JPanel();
            ButtonGroup encodingGroup = new ButtonGroup();
            linrB = addToggleButton(p1, encodingGroup, "linear", true);
            ulawB = addToggleButton(p1, encodingGroup, "ulaw", false);
            alawB = addToggleButton(p1, encodingGroup, "alaw", false);
            add(p1);
            groups.addElement(encodingGroup);
               
            JPanel p2 = new JPanel();
            JPanel p2b = new JPanel();
            ButtonGroup sampleRateGroup = new ButtonGroup();
            rate8B = addToggleButton(p2, sampleRateGroup, "8000", false);
            rate11B = addToggleButton(p2, sampleRateGroup, "11025", false);
            rate16B = addToggleButton(p2b, sampleRateGroup, "16000", false);
            rate22B = addToggleButton(p2b, sampleRateGroup, "22050", false);
            rate44B = addToggleButton(p2b, sampleRateGroup, "44100", true);
            add(p2);
	    add(p2b);
            groups.addElement(sampleRateGroup);
    
            JPanel p3 = new JPanel();
            ButtonGroup sampleSizeInBitsGroup = new ButtonGroup();
            size8B = addToggleButton(p3, sampleSizeInBitsGroup, "8", false);
            size16B = addToggleButton(p3, sampleSizeInBitsGroup, "16", true);
            add(p3);
            groups.addElement(sampleSizeInBitsGroup);
    
            JPanel p4 = new JPanel();
            ButtonGroup signGroup = new ButtonGroup();
            signB = addToggleButton(p4, signGroup, "signed", true);
            unsignB = addToggleButton(p4, signGroup, "unsigned", false);
            add(p4);
            groups.addElement(signGroup);

            JPanel p5 = new JPanel();
            ButtonGroup endianGroup = new ButtonGroup();
            litB = addToggleButton(p5, endianGroup, "little endian", false);
            bigB = addToggleButton(p5, endianGroup, "big endian", true);
            add(p5);
            groups.addElement(endianGroup);

            JPanel p6 = new JPanel();
            ButtonGroup channelsGroup = new ButtonGroup();
            monoB = addToggleButton(p6, channelsGroup, "mono", false);
            sterB = addToggleButton(p6, channelsGroup, "stereo", true);
            add(p6);
            groups.addElement(channelsGroup);
        }
    
        private JToggleButton addToggleButton(JPanel p, ButtonGroup g, 
                                     String name, boolean state) {
            JToggleButton b = new JToggleButton(name, state);
            p.add(b);
            g.add(b);
            return b;
        }

        public AudioFormat getFormat() {

            Vector v = new Vector(groups.size());
            for (int i = 0; i < groups.size(); i++) {
                ButtonGroup g = (ButtonGroup) groups.get(i);
                for (Enumeration e = g.getElements();e.hasMoreElements();) {
                    AbstractButton b = (AbstractButton) e.nextElement();
                    if (b.isSelected()) {
                        v.add(b.getText());
                        break;
                    }
                }
            }

            AudioFormat.Encoding encoding = AudioFormat.Encoding.ULAW;
            String encString = (String) v.get(0);
            float rate = Float.valueOf((String) v.get(1)).floatValue();
            int sampleSize = Integer.valueOf((String) v.get(2)).intValue();
            String signedString = (String) v.get(3);
            boolean bigEndian = ((String) v.get(4)).startsWith("big");
            int channels = ((String) v.get(5)).equals("mono") ? 1 : 2;

            if (encString.equals("linear")) {
                if (signedString.equals("signed")) {
                    encoding = AudioFormat.Encoding.PCM_SIGNED;
                } else {
                    encoding = AudioFormat.Encoding.PCM_UNSIGNED;
                }
            } else if (encString.equals("alaw")) {
                encoding = AudioFormat.Encoding.ALAW;
            }
            return new AudioFormat(encoding, rate, sampleSize, 
                          channels, (sampleSize/8)*channels, rate, bigEndian);
        }


        public void setFormat(AudioFormat format) {
            AudioFormat.Encoding type = format.getEncoding();
            if (type == AudioFormat.Encoding.ULAW) {
                ulawB.doClick();
            } else if (type == AudioFormat.Encoding.ALAW) {
                alawB.doClick();
            } else if (type == AudioFormat.Encoding.PCM_SIGNED) {
                linrB.doClick(); signB.doClick(); 
            } else if (type == AudioFormat.Encoding.PCM_UNSIGNED) {
                linrB.doClick(); unsignB.doClick(); 
            }
            float rate = format.getFrameRate();
            if (rate == 8000) {
                rate8B.doClick();
            } else if (rate == 11025) {
                rate11B.doClick();
            } else if (rate == 16000) {
                rate16B.doClick();
            } else if (rate == 22050) {
                rate22B.doClick();
            } else if (rate == 44100) {
                rate44B.doClick();
            }
            switch (format.getSampleSizeInBits()) {
                case 8  : size8B.doClick(); break;
                case 16 : size16B.doClick(); break;
            }
            if (format.isBigEndian()) {
                bigB.doClick(); 
            } else { 
                litB.doClick();
            }
            if (format.getChannels() == 1) {
                monoB.doClick(); 
            } else { 
                sterB.doClick();
            }
        }
    } // End class FormatControls


    public static void main(String s[]) {
        CapturePlayback capturePlayback = new CapturePlayback();
        capturePlayback.open();
        JFrame f = new JFrame("Capture/Playback");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        f.getContentPane().add("Center", capturePlayback);
        f.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = 720;
        int h = 340;
        f.setLocation(screenSize.width/2 - w/2, screenSize.height/2 - h/2);
        f.setSize(w, h);
        f.show();
    }
} 
