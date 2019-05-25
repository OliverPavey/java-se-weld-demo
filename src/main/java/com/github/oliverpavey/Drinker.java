package com.github.oliverpavey;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Representation of Drinker with drinking action.
 * 
 * @author Oliver Pavey
 *
 */
@ApplicationScoped
public class Drinker {

	@Inject
	Beverage beverage;
	
	public String drink() {
		return String.format("The %s tastes %s.", beverage.getName(), beverage.getTaste());
	}
}
	
