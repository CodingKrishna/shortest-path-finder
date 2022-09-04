package com.shortestpathfinder.handlers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.shortestpathfinder.datastructure.Location;
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
		// TODO: instead of path param's read FindShortestPathDTO from request body.
		final int destX = Integer.parseInt(request.queryParam("destX").orElse("0"));
		final int destY = Integer.parseInt(request.queryParam("destY").orElse("0"));
		final int robotId = Integer.parseInt(request.queryParam("robotId").orElse("1"));
		log.info("Request paramter robotId:{} startVertex:{} destVertex:{}", robotId, destX, destY);
		List<Location> path = shortestPathFinderService.findShortestPath(robotId, destX, destY);
		for(Location v: path) {
			System.out.print(v + " ---> ");
		}
		return ok().contentType(APPLICATION_JSON)
				.body(Flux.fromIterable(path), List.class)
				.switchIfEmpty(notFound().build());
	}
}
