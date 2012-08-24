package com.weltevree.harmonica;

import com.weltevree.harmonica.internal.CapturePlayback;

public class Capture {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		CapturePlayback capture = new CapturePlayback();

		System.out.println("Capturing ...");
		capture.getCapture().start();
		Thread.sleep(5000);
		capture.getCapture().stop();
		System.out.println("Captured");
		Thread.sleep(1000);
		System.out.println("Playback");
		capture.getPlayback().start();
		Thread.sleep(5000);
		capture.getPlayback().stop();
	}
}
