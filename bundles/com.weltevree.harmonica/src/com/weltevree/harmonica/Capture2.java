package com.weltevree.harmonica;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import com.weltevree.harmonica.internal.CapturePlayback;

public class Capture2 {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		CapturePlayback cpb = new CapturePlayback();


		// while (true) {
		for (int i = 0; i < 5; i++) {

			System.out.println("Capturing ...");
			cpb.getCapture().start();
			Thread.sleep(1000);
			// System.out.println("Captured");
			// Thread.sleep(1000);
			// System.out.println("Playback");
			// capture.getCapture().flush();
			// capture.getPlayback().start();
			// capture.getPlayback().stop();
			// Thread.sleep(5000);
			// }
			// capture.getCapture().pause();
			cpb.getCapture().stop();
			System.out.println(cpb.getCapture().getAudioBytes().length);

			float[] four1 = four1(cpb.getCapture().getAudioBytes(), cpb.getCapture().getAudioBytes().length / 4, 1);
			System.out.println(four1.length);
			cpb.getPlayback().start(cpb.getCapture().getAudioBytes());

			System.out.println();
			// capture.getCapture().flush();
			// capture.getCapture().resume();

		}
	}

	public static float[] four1(byte[] dataIn, int nn, int isign) {

		ByteBuffer buffer = ByteBuffer.allocate(dataIn.length);
		buffer.put(dataIn);

		FloatBuffer floatBuffer = FloatBuffer.allocate(nn);
		buffer.rewind();
		while (buffer.hasRemaining())
			floatBuffer.put(buffer.getFloat());

		float[] data = floatBuffer.array();

		// for (int i = 0; i < data.length; i++) {
		// System.out.println(data[i]);
		// }

		int i, j, n, mmax, m, istep;
		float wtemp, wr, wpr, wpi, wi, theta, tempr, tempi;

		n = nn / 2 << 1;
		// System.out.println(n);
		j = 1;
		for (i = 1; i < n; i += 2) {
			if (j > i) {
				float temp;
				temp = data[j];
				data[j] = data[i];
				data[i] = temp;
				temp = data[j + 1];
				data[j + 1] = data[i + 1];
				data[i + 1] = temp;
			}
			m = n >> 1;
			while (m >= 2 && j > m) {
				j -= m;
				m >>= 1;
			}
			j += m;
		}
		mmax = 2;

		while (n > mmax) {
			istep = (mmax << 1);
			theta = (float) (isign * (6.28318530717959 / mmax));
			wtemp = (float) Math.sin(0.5 * theta);
			wpr = (float) (-2.0 * wtemp * wtemp);
			wpi = (float) Math.sin(theta);
			wr = (float) 1.0;
			wi = (float) 0.0;
			for (m = 1; m < mmax; m += 2) {
				for (i = m; i <= n; i += istep) {
					j = i + mmax;
					tempr = wr * data[j] - wi * data[j + 1];
					tempi = wr * data[j + 1] + wi * data[j];
					data[j] = data[i] - tempr;
					data[j + 1] = data[i + 1] - tempi;
					data[i] += tempr;
					data[i + 1] += tempi;
				}
				wr = (wtemp = wr) * wpr - wi * wpi + wr;
				wi = wi * wpr + wtemp * wpi + wi;
			}
			mmax = istep;
		}
		return data;
	}

}
