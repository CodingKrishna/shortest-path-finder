package com.shortestpathfinder.algo;

import com.shortestpathfinder.datastructure.Location;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrentLocation {

	Location poped;

	PathFinderConfig configInput;
}
