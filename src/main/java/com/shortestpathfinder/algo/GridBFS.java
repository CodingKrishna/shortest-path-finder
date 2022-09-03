package com.shortestpathfinder.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.shortestpathfinder.datastructure.Grid;

public class GridBFS {
	Grid grid;

	public GridBFS(Grid g) {
		this.grid = g;
	}

	// Function to perform BFS on the graph
	public void bfs(int start, int end) {
		// Number of vertex
		int v = grid.getVertexs();

		// Adjacency matrix
		int[][] adj = grid.getMatrix();

		// Visited vector to so that
		// a vertex is not visited more than once
		// Initializing the vector to false as no
		// vertex is visited at the beginning
		boolean[] visited = new boolean[v];
		Arrays.fill(visited, false);
		List<Integer> q = new ArrayList<>();
		q.add(start);

		// Set source as visited
		visited[start] = true;

		int vis;
		while (!q.isEmpty()) {
			vis = q.get(0);

			// Print the current node
			System.out.print(vis + " ");
			q.remove(q.get(0));

			if(vis == end) {
				break;
			}
			
			// For every adjacent vertex to
			// the current vertex
			for (int i = 0; i < v; i++) {
				if (adj[vis][i] == 1 && (!visited[i])) {

					// Push the adjacent node to
					// the queue
					q.add(i);

					// Set
					visited[i] = true;
				}
			}
		}
	}
}
