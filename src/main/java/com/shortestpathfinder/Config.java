package com.shortestpathfinder;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.shortestpathfinder.datastructure.Edge;

import lombok.Data;

@Configuration
//@ConfigurationProperties(prefix = "graph")
@Component
@Data
public class Config {

	@Value("${graph.vertices}")
	public int vertices = 3;

	public List<Edge> edges = new LinkedList<Edge>();

	public Config() {
		edges.add(new Edge(0, 1));
		edges.add(new Edge(1, 2));
		edges.add(new Edge(2, 0));
	}

}
