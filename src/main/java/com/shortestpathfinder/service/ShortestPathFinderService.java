package com.shortestpathfinder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shortestpathfinder.algo.GridBFSWithMultiCapabilites;
import com.shortestpathfinder.datastructure.Grid;
import com.shortestpathfinder.datastructure.Vertex;
import com.shortestpathfinder.robot.Robot;
import com.shortestpathfinder.robot.service.RobotService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ShortestPathFinderService {

	private Grid grid;
	private RobotService robotService;

	public List<Vertex> findShortestPath(int robotId, int sourceVertex, int destVertex) {
		Robot r = robotService.getRobot(robotId);
		GridBFSWithMultiCapabilites gridBFSWithMultiCapabilites = new GridBFSWithMultiCapabilites(grid);
		return gridBFSWithMultiCapabilites.bfs(sourceVertex, destVertex, r.getCapabilies());
	}
}
