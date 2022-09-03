package com.shortestpathfinder.robot;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Robot {

	@Id
	int id;

	String name;

	Set<Capability> capabilies = new HashSet<>();

}
