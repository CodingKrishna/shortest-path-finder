package com.shortestpathfinder.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.shortestpathfinder.datastructure.Edge;
import com.shortestpathfinder.datastructure.Graph;
import com.shortestpathfinder.datastructure.Vertex;

public class GraphBFS {
	Graph graph;

	public GraphBFS(Graph graph) {
		this.graph = graph;
	}

	List<Vertex> visited = new ArrayList<>();
	Queue<Vertex> queue = new LinkedList<>();

	public void bfs(Vertex startV) {
		visited.add(startV);
		List<Edge> adjacent = graph.getEdges(startV);
		for (Edge ed : adjacent) {
			if (ed.getSrc() == startV.getId() && !visited.contains(graph.getVertices().get(ed.getDest()))) {
				queue.add(graph.getVertices().get(ed.getDest()));
			}
		}
		while (!queue.isEmpty()) {
			bfs(queue.poll());
		}
	}

	public void showVisitedNodes() {
		System.out.println(visited);
	}

	public static void main(String[] args) {
//		Vertex n1 = new Vertex(0,"Rack 1");
//		Vertex n2 = new Vertex(1,"Rack 2");
//		Vertex n3 = new Vertex(2,"Rack 3");
//		Graph g = new Graph(List.of(n1, n2, n3));
//
//		g.addEdge(new Edge(0, 1));
//		g.addEdge(new Edge(1, 2));
//		g.addEdge(new Edge(2, 0));
//
//		GraphBFS bfs = new GraphBFS(g);
//		bfs.bfs(n1);
//		bfs.showVisitedNodes();
	}
}
