package com.github.oliverpavey;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

public class DrinkerTest {

	@Test
	public void teaDrinkerTest() {
		
		Beverage mockBeverage = new Beverage() {
			
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "tea";
			}
			
			@Override
			public String getTaste() {
				return "teriffic";
			}
			
		};
		
		Drinker drinker = new Drinker();
		drinker.beverage = mockBeverage;
		
		String output = drinker.drink();
		
		assertThat(output, containsString("The tea tastes teriffic."));
	}

}
