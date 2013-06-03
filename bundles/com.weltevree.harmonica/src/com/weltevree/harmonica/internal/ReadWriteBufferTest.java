package com.weltevree.harmonica.internal;

import java.io.ByteArrayOutputStream;
import java.util.Random;

public class ReadWriteBufferTest implements Runnable {

	private static ByteArrayOutputStream buffer;

	public static void main(String[] args) throws InterruptedException {

		Thread writeThread = new Thread(new ReadWriteBufferTest(), "writer");
		// writeThread.setDaemon(true);
		writeThread.start();

		Thread.sleep(100);
		Thread readThread = new Thread(new ReadWriteBufferTest(), "reader");
		// readThread.setDaemon(true);
		readThread.start();

	}

	public void run() {

		if (buffer != null)
			startRead();
		else {
			buffer = new ByteArrayOutputStream();
			startWrite();
		}
	}

	public void startRead() {
		while (buffer != null) {
			while (buffer.size() != 0) {
				System.out.println(buffer.toByteArray()[0]);
				buffer.reset();
			}
		}
	}

	public void startWrite() {
		while (buffer != null)
			buffer.write(new Random().nextInt());
	}
}
