package com.shortestpathfinder.algo;

import java.util.LinkedList;
import java.util.List;

import com.shortestpathfinder.datastructure.Location;

public class ShortestPathFinderImpl implements ShortestPathFinder {

	@Override
	public List<Location> findShortestPath(PathFinderConfig config, Location source, Location destination) {
		return findShortestPath(config, source, destination, this::addNeighbours);
	}

	public List<Location> addNeighbours(CurrentLocation ip) {
		Location poped = ip.getPoped();
		int[][] matrix = ip.getConfigInput().getMatrix();
		List<Location> list = new LinkedList<Location>();

		
		if ((poped.x - 1 > -1 && poped.x - 1 < matrix.length) && matrix[poped.x - 1][poped.y] != 0) {
			list.add(new Location(poped.x - 1, poped.y, poped.distanceFromSource + 1));
		}
		if ((poped.x + 1 > -1 && poped.x + 1 < matrix.length) && matrix[poped.x + 1][poped.y] != 0) {
			list.add(new Location(poped.x + 1, poped.y, poped.distanceFromSource + 1));
		}
		if ((poped.y - 1 > -1 && poped.y - 1 < matrix.length) && matrix[poped.x][poped.y - 1] != 0) {
			list.add(new Location(poped.x, poped.y - 1, poped.distanceFromSource + 1));
		}
		if ((poped.y + 1 > -1 && poped.y + 1 < matrix.length) && matrix[poped.x][poped.y + 1] != 0) {
			list.add(new Location(poped.x, poped.y + 1, poped.distanceFromSource + 1));
		}
		// TODO: based on steps and directions, above logic need to enhance.
		/**
		 * // check all four possible movements from the current cell
	        // and recur for each valid movement
	        for (int i = 0; i < row.length; i++)
	        {
	            // get the next position using the value of the current cell
	            int x = curr.first + row[i] * n;
	            int y = curr.second + col[i] * n;
	 
	            Node next = new Node(x, y);
	 
	            // check if it is possible to go to a position (x, y)
	            // from the current position
	            if (isValid(path, next, N) && findPath(mat, path, next)) {
	                return true;
	            }
	        }
		 */
		return list;
	}

	
}