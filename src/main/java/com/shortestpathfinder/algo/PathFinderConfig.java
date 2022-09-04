package com.shortestpathfinder.algo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PathFinderConfig {
	
	int[][] matrix;
	
	int[] col;

	int[] row;

	int steps;

	int weight;
	
	public PathFinderConfig(int[][] matrix){
		this.matrix = matrix;
	}
}
