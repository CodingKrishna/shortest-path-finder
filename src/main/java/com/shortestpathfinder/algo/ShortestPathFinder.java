package com.shortestpathfinder.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;

import com.shortestpathfinder.datastructure.Location;

public interface ShortestPathFinder {

	public default List<Location> findShortestPath(PathFinderConfig config, Location source, Location destination,
			Function<CurrentLocation, List<Location>> neighbourListFun) {
		int[][] matrix = config.getMatrix();
		Queue<Location> queue = new LinkedList<Location>();

		queue.add(source);

		List<Location> visitedVertex = new ArrayList<>();

		while (!queue.isEmpty()) {
			Location poped = queue.poll();
			visitedVertex.add(poped);

			if (poped.x == destination.x && poped.y == destination.y) {
				break;
			} else {
				matrix[poped.x][poped.y] = 0;

				List<Location> neighbourList = neighbourListFun.apply(new CurrentLocation(poped, config));
				queue.addAll(neighbourList);
			}
		}
		return visitedVertex;
	}

	public List<Location> findShortestPath(PathFinderConfig config, Location source, Location destination);
	
}
