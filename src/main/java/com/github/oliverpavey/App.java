package com.github.oliverpavey;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * Print report from drinker.
 *
 */
public class App 
{
	public static void main( String[] args )
    {
    	SeContainerInitializer initializer = SeContainerInitializer.newInstance();
    	try (SeContainer container = initializer.initialize()) {
    		Instance<Drinker> lazyDrinker = container.select(Drinker.class);
    		Drinker drinker = lazyDrinker.get();
    		System.out.println(drinker.drink());
    	}
    }
}
