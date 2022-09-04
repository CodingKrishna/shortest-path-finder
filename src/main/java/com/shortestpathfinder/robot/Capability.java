package com.shortestpathfinder.robot;

import com.shortestpathfinder.algo.PathFinderConfig;

public interface Capability {
	
	CapabilityType getType();
	
	public void updateConfig(PathFinderConfig ip);
}
