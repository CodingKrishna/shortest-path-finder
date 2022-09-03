package com.shortestpathfinder.robot.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.shortestpathfinder.robot.Capability;
import com.shortestpathfinder.robot.Directions;
import com.shortestpathfinder.robot.RoboStepsCapability;
import com.shortestpathfinder.robot.RoboWeightCapability;
import com.shortestpathfinder.robot.Robot;

@Service
public class RobotService {

	private static final Map<Integer, Robot> ROBOTS = new HashMap<>();

	public RobotService() {
		addRobot(createDummyRobo());
		addRobot(createDummyRobo2());
	}

	public Robot addRobot(Robot r) {
		return ROBOTS.put(r.getId(), r);
	}

	public Robot getRobot(int id) {
		return ROBOTS.get(id);
	}

	public static Robot createDummyRobo() {
		RoboWeightCapability rwc = new RoboWeightCapability(12);
		RoboStepsCapability rsc = new RoboStepsCapability(2, Directions.ALL);
		Set<Capability> capabilies = new HashSet<>();
		capabilies.add(rwc);
		capabilies.add(rsc);
		return new Robot(1, "Rajin Robot", capabilies);
	}

	public static Robot createDummyRobo2() {
		RoboWeightCapability rwc = new RoboWeightCapability(2);
		RoboStepsCapability rsc = new RoboStepsCapability(1, Directions.ALL);
		Set<Capability> capabilies = new HashSet<>();
		capabilies.add(rwc);
		capabilies.add(rsc);
		return new Robot(2, "Sivaji Robot", capabilies);
	}
}
