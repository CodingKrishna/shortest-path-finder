package com.shortestpathfinder;

import java.util.List;

import com.shortestpathfinder.algo.GraphBFS;
import com.shortestpathfinder.algo.GridBFS;
import com.shortestpathfinder.algo.GridBFSWithMultiCapabilites;
import com.shortestpathfinder.datastructure.Graph;
import com.shortestpathfinder.datastructure.Grid;
import com.shortestpathfinder.datastructure.Vertex;
import com.shortestpathfinder.robot.Robot;
import com.shortestpathfinder.robot.service.RobotService;

public class TestApp {

	public static void main(String[] args) {

		Graph graph = new Graph(new Config(3));
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

		int start = 2;
		int end = 0;
		GridBFSWithMultiCapabilites gridBFSWithMultiCapabilites = new GridBFSWithMultiCapabilites(grid);
		List<Vertex> visted = gridBFSWithMultiCapabilites.bfs(start, end, r.getCapabilies());
		System.out.println();
		System.out.println("=============== Shortest Path between start:" + start + " to end:" + end+" ==============");
		for (Vertex v : visted) {
			System.out.print(v + " ---> ");
		}
	}

}
