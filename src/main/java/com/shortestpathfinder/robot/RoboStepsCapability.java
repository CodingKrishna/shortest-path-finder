package com.shortestpathfinder.robot;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoboStepsCapability implements StepsCapability {

	int steps;

	Directions directions = Directions.ALL;

}
