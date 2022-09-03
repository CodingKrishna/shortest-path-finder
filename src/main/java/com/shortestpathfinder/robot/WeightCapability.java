package com.shortestpathfinder.robot;

public interface WeightCapability extends Capability {

	@Override
	public default CapabilityType getType() {
		return CapabilityType.WEIGHT;
	}
	
	int getWeight();

}
