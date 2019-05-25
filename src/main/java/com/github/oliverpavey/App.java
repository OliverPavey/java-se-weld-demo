package com.github.oliverpavey;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * Print report from drinker.
 *
 * @author Oliver Pavey
 *
 */
public class App 
{
	
	/**
	 * Application main method. Obtains, initialises and closes Java EE container.
	 * 
	 * @param args	System requirement. Ignored.
	 */
	public static void main( String[] args )
    {
		// Obtain JavaEE container instance.
    	SeContainerInitializer initializer = SeContainerInitializer.newInstance();
    	
		// Initialize JavaEE container
    	try (SeContainer container = initializer.initialize()) {
    		
    		// Get drinker from Java EE.  (Drinker should have a beverage injected.)
    		Instance<Drinker> lazyDrinker = container.select(Drinker.class);
    		Drinker drinker = lazyDrinker.get();
    		
    		// Print result of drinker drinking (which will reveal beverage)
    		System.out.println(drinker.drink());
    		
    	} // Try with resources block closes Java EE container.
    }
}
