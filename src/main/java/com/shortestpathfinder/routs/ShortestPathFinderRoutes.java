package com.shortestpathfinder.routs;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.shortestpathfinder.handlers.FindShortestPathHandler;

@Configuration
public class ShortestPathFinderRoutes {

	  @Bean
	    public RouterFunction<ServerResponse> routes(FindShortestPathHandler findShortestPathHandler) {

	        return RouterFunctions.route()
	                .path("/api/", builder -> builder
	                		.GET("findshortestpath/{robotId}/{startVertex}/{destVertex}", accept(MediaType.APPLICATION_JSON), findShortestPathHandler::findPath))
	                .build();
	    }
	  
}
