package com.github.oliverpavey;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for App main.
 * 
 * @author Oliver Pavey
 *
 */
public class AppTest {
	
	private SeContainer container;

	/**
	 * Create the Java EE container.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
    	container = initializer.initialize();
	}

	/**
	 * Close the Java EE container.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		container.close();
	}

	/**
	 * Run the main method, allowing default injection, and validate output.
	 * 
	 * @throws Exception
	 */
	@Test
	public void runMainMethodTest() throws Exception {
		
		String output = null;
		try (SysOutCapture capture = new SysOutCapture()) {
			
			App.main(new String[] {});
			
			output = capture.getOutput();
		}

		assertNotNull(output);
		assertThat(output, containsString("The coffee tastes awesome."));
	}
}
