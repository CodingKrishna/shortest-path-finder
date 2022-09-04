package com.shortestpathfinder.robot;

import java.util.List;

import com.shortestpathfinder.algo.PathFinderConfig;

public interface StepsCapability extends Capability {

	@Override
	public default CapabilityType getType() {
		return CapabilityType.STEPS;
	}
	
	int getSteps();

	List<Directions> getDirections();
	
	
	public default void updateConfig(PathFinderConfig ip) {
		ip.setSteps(getSteps());
	}
}
