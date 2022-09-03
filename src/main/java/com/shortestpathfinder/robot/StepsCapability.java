package com.shortestpathfinder.robot;

public interface StepsCapability extends Capability {

	@Override
	public default CapabilityType getType() {
		return CapabilityType.STEPS;
	}
	
	int getSteps();

	Directions getDirections();
}
