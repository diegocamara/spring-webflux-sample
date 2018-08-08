package com.example.reactiveapplication.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.reactiveapplication.dao.entity.Solicitation;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface SolicitationRepository extends ReactiveMongoRepository<Solicitation, String> {

    Flux<Solicitation> findByAuthor(String author);

    Flux<Solicitation> findByAuthorAndDeleteIsFalse(String titleKeyword);

    Mono<Solicitation> findByTitle(String title);

    Mono<Solicitation> findByIdAndDeleteIsFalse(String id);

}
