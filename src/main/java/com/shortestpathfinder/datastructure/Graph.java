package com.shortestpathfinder.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.shortestpathfinder.Config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Component
@Data
public class Graph {

	private List<Vertex> vertices = new LinkedList<>();
	Map<Vertex, List<Edge>> graph = new HashMap<>();

	public Graph(Config config) {
		IntStream.range(0, config.getVertices()).forEach(x -> {
			Vertex v1 = new Vertex(x, "Rack " + x);
			vertices.add(v1);
			graph.put(v1, new ArrayList<>());
		});
		config.getEdges().forEach(edge -> {
			addEdge(edge);
		});
		printGraph();
		log.info("Graph Created successfully.");
	}

	public void addEdge(Edge e) {
		Optional.ofNullable(e).ifPresent(x -> {
			graph.get(vertices.get(x.getSrc())).add(e);
		});
	}

	public List<Edge> getEdges(Vertex v) {
		return graph.get(v);
	}

	public void printGraph() {
		for (Vertex vertex : graph.keySet()) {
			List<Edge> le = graph.get(vertex);
			for (Edge e : le) {
				System.out.println("Source::" + e.getSrc() + " Dest::" + e.getDest() + " Weight:" + e.getWeight());
			}
		}
	}
}
