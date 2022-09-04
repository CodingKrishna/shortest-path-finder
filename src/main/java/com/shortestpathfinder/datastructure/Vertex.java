package com.shortestpathfinder.datastructure;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Vertex {

	@Id
	@EqualsAndHashCode.Include
	int id;

	String name;

}
