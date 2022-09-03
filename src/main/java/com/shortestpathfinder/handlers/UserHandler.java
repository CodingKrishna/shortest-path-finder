package com.shortestpathfinder.handlers;

import com.shortestpathfinder.model.User;
import com.shortestpathfinder.repository.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@AllArgsConstructor
public class UserHandler {

    private UserRepository userRepository;

    public Mono<ServerResponse> createUser(ServerRequest request) {
        Mono<User> user = request.bodyToMono(User.class);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(user.flatMap(userRepository::save), User.class));
    }

    public Mono<ServerResponse> getUser(ServerRequest request) {
        final int id = Integer.parseInt(request.pathVariable("id"));
        final Mono<User> user = userRepository.findById(id);
        return user.flatMap(usr -> ok().contentType(APPLICATION_JSON)
                .body(fromPublisher(user, User.class)))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> getUsers(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON)
                .body(fromPublisher(userRepository.findAll(), User.class));
    }

}
