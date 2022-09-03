package com.shortestpathfinder.datastructure;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.shortestpathfinder.Config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Configuration
@Component
public class Grid {

	int vertexs = 0;
	List<Vertex> vertices;
	int[][] matrix;

	public Grid(Graph graph) {
		this.vertexs = graph.getVertices().size();
		this.vertices = graph.getVertices();
		
		matrix = new int[vertexs][vertexs];
		for (Vertex v : graph.getVertices()) {
			List<Edge> edges = graph.getEdges(v);
			for (Edge edge : edges) {
				if (v.getId() == edge.getSrc()) {
					matrix[v.getId()][edge.getDest()] = 1;
				}
			}
		}
		log.info("Grid Created successfully.");
	}

	public void printGraph() {
		System.out.println("Graph: (Adjacency Matrix)");
		for (int i = 0; i < this.vertexs; i++) {
			for (int j = 0; j < this.vertexs; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < this.vertexs; i++) {
			System.out.print("Vertex " + i + " is connected to:");
			for (int j = 0; j < this.vertexs; j++) {
				if (matrix[i][j] == 1) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
//		Vertex n1 = new Vertex(0, "Rack 1");
//		Vertex n2 = new Vertex(1, "Rack 2");
//		Vertex n3 = new Vertex(2, "Rack 3");
//		Graph g = new Graph(List.of(n1, n2, n3));
//
//		g.addEdge(new Edge(0, 1));
//		g.addEdge(new Edge(1, 2));
//		g.addEdge(new Edge(2, 0));
//		g.printGraph();
//
//		Grid grid = new Grid(g);
//		grid.printGraph();
		
		Config c = new Config();
		c.setVertices(3);
		Graph g = new Graph(c);
		Grid grid = new Grid(g);
		grid.printGraph();

	}
}
