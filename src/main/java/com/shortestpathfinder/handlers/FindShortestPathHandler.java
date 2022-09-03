package com.shortestpathfinder.handlers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.shortestpathfinder.datastructure.Vertex;
import com.shortestpathfinder.service.ShortestPathFinderService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
@Slf4j
public class FindShortestPathHandler {

	private ShortestPathFinderService shortestPathFinderService;

	public Mono<ServerResponse> findPath(ServerRequest request) {
		log.info("Request received to process shortest path..");
		final int startVertex = Integer.parseInt(request.pathVariable("startVertex"));
		final int destVertex = Integer.parseInt(request.pathVariable("destVertex"));
		final int robotId = Integer.parseInt(request.pathVariable("robotId"));
		log.info("Request paramter robotId:{} startVertex:{} destVertex:{}", robotId, startVertex, destVertex);
		List<Vertex> path = shortestPathFinderService.findShortestPath(robotId, startVertex, destVertex);
		for(Vertex v: path) {
			System.out.print(v + " ---> ");
		}
		return ok().contentType(APPLICATION_JSON)
				.body(Flux.fromIterable(path), List.class)
				.switchIfEmpty(notFound().build());
	}

	// TODO: 
//	FindShortestPathDTO findShortestPathDTO = request.bodyToMono(FindShortestPathDTO.class).toProcessor().peek();
//	final int startVertex = findShortestPathDTO.getStartVertex();
//	final int destVertex = findShortestPathDTO.getDestVertex();
//	final int robotId = findShortestPathDTO.getRobotId();
}
