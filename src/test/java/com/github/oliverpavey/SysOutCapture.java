package com.github.oliverpavey;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Convenience class to capture standard out, for use in testing.
 * 
 * Implements AutoCloseable and must be closed.  Typical usage:
 * 
 * 		String output = null;
 * 		try (SysOutCapture capture = new SysOutCapture()) {
 * 			
 * 			// Test code (which writes to sysout) goes here.
 * 			
 * 			output = capture.getOutput();
 * 		}
 * 
 * @author Oliver Pavey
 *
 */
public class SysOutCapture implements AutoCloseable {

	private PrintStream originalSystemOut;
	private ByteArrayOutputStream captureOutputStream; 

	/**
	 * Constructor, which takes over sysout.
	 */
	public SysOutCapture() {
		originalSystemOut = System.out;
		captureOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(captureOutputStream));
	}
	
	/**
	 * Close method, which restores previous sysout.
	 */
	@Override
	public void close() throws Exception {
		System.setOut(originalSystemOut);
	}
	
	/**
	 * Sysout data access method
	 * 
	 * @return	String of data written to sysout whilst redirected
	 */
	public String getOutput() {
		return captureOutputStream.toString();
	}

}
