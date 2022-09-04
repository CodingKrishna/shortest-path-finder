package com.shortestpathfinder.datastructure;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Location {
	public int x;
	public int y;
	public int distanceFromSource;
    
    public Location(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.distanceFromSource = dis;
    }
}
