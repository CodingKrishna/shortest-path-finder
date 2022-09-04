package com.shortestpathfinder;

import java.util.List;
import java.util.Set;

import com.shortestpathfinder.algo.PathFinderConfig;
import com.shortestpathfinder.algo.GraphBFS;
import com.shortestpathfinder.algo.GridBFS;
import com.shortestpathfinder.algo.GridBFSWithMultiCapabilites;
import com.shortestpathfinder.algo.ShortestPathFinderImpl;
import com.shortestpathfinder.datastructure.Graph;
import com.shortestpathfinder.datastructure.Grid;
import com.shortestpathfinder.datastructure.Location;
import com.shortestpathfinder.datastructure.Vertex;
import com.shortestpathfinder.robot.Capability;
import com.shortestpathfinder.robot.Robot;
import com.shortestpathfinder.robot.service.RobotService;

public class TestApp {

	public static void main(String[] args) {

		Graph graph = new Graph(new Config(4));
		// graph.printGraph();

		Grid grid = new Grid(graph);
		// grid.printGraph();

		RobotService rs = new RobotService();
		Robot r = rs.getRobot(2);

//		GraphBFS bfs = new GraphBFS(graph);
//		bfs.bfs(grid.getVertices().get(0));
//		bfs.showVisitedNodes();

//		GridBFS gridBfs =  new GridBFS(grid);
//		gridBfs.bfs(1,2);

		int start = 0;
		int end = 2;
		// GridBFSWithMultiCapabilites gridBFSWithMultiCapabilites = new
		// GridBFSWithMultiCapabilites(grid);
		// List<Vertex> visted = gridBFSWithMultiCapabilites.bfs(start, end,
		// r.getCapabilies());

		ShortestPathFinderImpl sp = new ShortestPathFinderImpl();
		Location source = new Location(0, 0, 0);
		Location destination = new Location(3, 3, 0);
		List<Location> visted = sp.findShortestPath(getDefaultConfig(grid), source, destination);

		
		System.out.println();
		System.out
				.println("=============== Shortest Path between start:" + start + " to end:" + end + " ==============");
		for (Location v : visted) {
			System.out.print("("+v.x+","+v.y+")");
		}
	}
	
	public static PathFinderConfig capabilitiesToConfigConverter(Grid grid, List<Capability> capabilities) {
		PathFinderConfig ci = new PathFinderConfig(grid.getMatrix());
		capabilities.stream().forEach(x -> {
			x.updateConfig(ci);
		});
		return ci;
	}

	public static PathFinderConfig getDefaultConfig(Grid grid) {
		int col[] = {};
		int row[] = {};
		int steps = 1;
		int weight = 0;
		return new PathFinderConfig(grid.getMatrix(), col, row, steps, weight);
	}

}
