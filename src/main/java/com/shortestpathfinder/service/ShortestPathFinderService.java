package com.shortestpathfinder.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.shortestpathfinder.algo.PathFinderConfig;
import com.shortestpathfinder.algo.ShortestPathFinderImpl;
import com.shortestpathfinder.algo.ShortestPathFinder;
import com.shortestpathfinder.datastructure.Grid;
import com.shortestpathfinder.datastructure.Location;
import com.shortestpathfinder.robot.Capability;
import com.shortestpathfinder.robot.Robot;
import com.shortestpathfinder.robot.service.RobotService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ShortestPathFinderService {

	private Grid grid;
	private RobotService robotService;

	public List<Location> findShortestPath(int robotId, int sourceVertex, int destVertex) {
		Robot r = robotService.getRobot(robotId);
		PathFinderConfig config = capabilitiesToConfigConverter(r.getCapabilies());
		
		Location source = new Location(0, 0, 0);
		Location destination = new Location(3, 3, 0);
		ShortestPathFinder shortestPathFinder = new ShortestPathFinderImpl();
		
		return shortestPathFinder.findShortestPath(config, source, destination);
	}
	
	
	public PathFinderConfig capabilitiesToConfigConverter(Set<Capability> capabilities) {
		PathFinderConfig ci = getDefaultConfig();
		capabilities.stream().forEach(x -> {
			x.updateConfig(ci);
		});
		return ci;
	}

	public PathFinderConfig getDefaultConfig() {
		int col[] = {};
		int row[] = {};
		int steps = 1;
		int weight = 0;
		return new PathFinderConfig(grid.getMatrix(), col, row, steps, weight);
	}
}
