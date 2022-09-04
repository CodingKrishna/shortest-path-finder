package com.shortestpathfinder.robot;

import com.shortestpathfinder.algo.PathFinderConfig;

public interface WeightCapability extends Capability {

	@Override
	public default CapabilityType getType() {
		return CapabilityType.WEIGHT;
	}
	
	int getWeight();

	public default void updateConfig(PathFinderConfig ip) {
		ip.setWeight(getWeight());
	}
}
