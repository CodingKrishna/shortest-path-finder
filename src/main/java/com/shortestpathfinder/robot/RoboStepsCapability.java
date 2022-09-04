package com.shortestpathfinder.robot;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoboStepsCapability implements StepsCapability {

	int steps;

	public List<Directions> getDirections(){
		return List.of(Directions.ALL);
	}
}
