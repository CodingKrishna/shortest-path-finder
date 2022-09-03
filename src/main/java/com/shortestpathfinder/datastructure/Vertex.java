package com.shortestpathfinder.datastructure;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Vertex {

	@Id
	@EqualsAndHashCode.Include
	int id;

	String name;

}
