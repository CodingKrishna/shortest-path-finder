package com.shortestpathfinder.datastructure;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

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
		printGraph();
		for (Vertex v : graph.getVertices()) {
			List<Edge> edges = graph.getEdges(v);
			for (Edge edge : edges) {
				if (v.getId() == edge.getSrc()) {
					log.info("Vertex:{} and dest:{}", v, edge.getDest());
					matrix[v.getId()][edge.getDest()] = 1;
				}
			}
		}
		printGraph();
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
//		for (int i = 0; i < this.vertexs; i++) {
//			System.out.print("Vertex " + i + " is connected to:");
//			for (int j = 0; j < this.vertexs; j++) {
//				if (matrix[i][j] == 1) {
//					System.out.print(j + " ");
//				}
//			}
//			System.out.println();
//		}
	}
}
