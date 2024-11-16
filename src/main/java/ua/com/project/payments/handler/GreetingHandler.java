package ua.com.project.payments.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.project.payments.entity.Account;
import ua.com.project.payments.entity.Client;

import java.util.Arrays;
import java.util.List;


@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("Hello World!"));
    }

    public Mono<ServerResponse> users(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("User Page"));
    }

    public Mono<ServerResponse> admin(ServerRequest request) {

        Account account1 = new Account(1L, 1000.0, false);
        Account account2 = new Account(2L, 1500.0, false);
        Account account3 = new Account(3L, 2000.0, true);


        Flux<Client> users = Flux.
                just(
                        new Client(1L, "Vasya", "Pypkin", Arrays.asList(account1, account2)),
                        new Client(2L, "Iva", "Pypkina", List.of(account3)),
                        new Client(3L, "Inna", "Pypkina", Arrays.asList(account1, account3))
                ));

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(users, Client.class);
    }

}