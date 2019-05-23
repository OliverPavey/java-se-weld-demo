package com.github.oliverpavey;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SysOutCapture implements AutoCloseable {

	private PrintStream originalSystemOut;
	private ByteArrayOutputStream captureOutputStream; 
	
	public SysOutCapture() {
		originalSystemOut = System.out;
		captureOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(captureOutputStream));
	}
	
	@Override
	public void close() throws Exception {
		System.setOut(originalSystemOut);
	}
	
	public String getOutput() {
		return captureOutputStream.toString();
	}

}
