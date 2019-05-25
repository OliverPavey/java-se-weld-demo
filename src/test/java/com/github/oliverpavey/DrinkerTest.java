package com.github.oliverpavey;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for Drinker class
 * 
 * @author Oliver Pavey
 *
 */
public class DrinkerTest {

	/**
	 * Basic test with stubbed beverage class.
	 */
	@Test
	public void teaDrinkerTest() {
		
		/**
		 * Create stub for implementing Beverage
		 */
		Beverage mockBeverage = new Beverage() {
			
			@Override
			public String getName() {
				return "tea";
			}
			
			@Override
			public String getTaste() {
				return "teriffic";
			}
			
		};
		
		// Inject beverage
		Drinker drinker = new Drinker();
		drinker.beverage = mockBeverage;
		
		String output = drinker.drink();
		
		assertThat(output, containsString("The tea tastes teriffic."));
	}

}
