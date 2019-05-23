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
 */
public class AppTest {
	
	private SeContainer container;

	@Before
	public void setUp() throws Exception {

		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
    	container = initializer.initialize();
	}

	@After
	public void tearDown() throws Exception {
		
		container.close();
	}

	@Test
	public void test2() throws Exception {
		
		String output = null;
		try (SysOutCapture capture = new SysOutCapture()) {
			
			App.main(new String[] {});
			
			output = capture.getOutput();
		}

		assertNotNull(output);
		assertThat(output, containsString("The coffee tastes awesome."));
	}
}
