package com.shortestpathfinder.datastructure;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {
	
	private int src;
	private int dest;
	private int weight = 0;

	public Edge(int src, int dest) {
		this.src = src;
		this.dest = dest;
	}
}
