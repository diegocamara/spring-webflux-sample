package com.example.reactiveapplication.service;

import com.example.reactiveapplication.dao.entity.Solicitation;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SolicitationService {

    Mono<Solicitation> create(Solicitation solicitation);

    Mono<Solicitation> update(Solicitation solicitation, String id);

    Flux<Solicitation> findAll();

    Mono<Solicitation> findOne(String id);

    Flux<Solicitation> findByTitle(String title);

    Mono<Boolean> delete(String id);

}
