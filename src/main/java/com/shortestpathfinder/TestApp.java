package com.shortestpathfinder;

import java.util.List;

import com.shortestpathfinder.algo.GraphBFS;
import com.shortestpathfinder.algo.GridBFS;
import com.shortestpathfinder.algo.GridBFSWithMultiCapabilites;
import com.shortestpathfinder.datastructure.Edge;
import com.shortestpathfinder.datastructure.Graph;
import com.shortestpathfinder.datastructure.Grid;
import com.shortestpathfinder.datastructure.Vertex;
import com.shortestpathfinder.robot.Robot;
import com.shortestpathfinder.robot.service.RobotService;

public class TestApp {

	public static void main(String[] args) {

		Vertex v1 = new Vertex(0, "Rack 1");
		Vertex v2 = new Vertex(1, "Rack 2");
		Vertex v3 = new Vertex(2, "Rack 3");

		Config c = new Config();
		c.setVertices(3);
		c.getEdges().add(new Edge(0, 1));
		c.getEdges().add(new Edge(1, 2));
		c.getEdges().add(new Edge(2, 0));
		
		Graph graph = new Graph(c);
		graph.addEdge(new Edge(0, 1));
		graph.addEdge(new Edge(1, 2));
		graph.addEdge(new Edge(2, 0));
		graph.printGraph();

		Grid grid = new Grid(graph);
		grid.printGraph();

		RobotService rs = new RobotService();
		Robot r = rs.getRobot(2);

		GraphBFS bfs = new GraphBFS(graph);
		bfs.bfs(v1);
		bfs.showVisitedNodes();
	
		GridBFS gridBfs =  new GridBFS(grid);
		gridBfs.bfs(1);

		GridBFSWithMultiCapabilites gridBFSWithMultiCapabilites = new GridBFSWithMultiCapabilites(grid);
		List<Vertex> visted = gridBFSWithMultiCapabilites.bfs(v1, r.getCapabilies());
		for(Vertex v: visted) {
			System.out.print(v + " ---> ");
		}
	}

	
}
