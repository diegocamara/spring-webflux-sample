package com.example.reactiveapplication.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.reactiveapplication.dao.entity.Solicitation;
import com.example.reactiveapplication.service.SolicitationService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/solicitation")
public class SolicitationController {

    private static final String ID = "/{id}";

    @Autowired
    private SolicitationService solicitationService;

    @GetMapping
    public Flux<Solicitation> findAll() {
        return this.solicitationService.findAll();
    }

    @GetMapping("/find")
    public Flux<Solicitation> findByTitle(@RequestParam String title) {
        return this.solicitationService.findByTitle(title);
    }

    @GetMapping(ID)
    public Mono<Solicitation> findOne(@PathVariable String id) {
        return this.solicitationService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Solicitation> create(@RequestBody Solicitation solicitation) {
        return this.solicitationService.create(solicitation);
    }

    @DeleteMapping(ID)
    public Mono<Boolean> delete(@PathVariable String id) {
        return this.solicitationService.delete(id);
    }

    @PutMapping(ID)
    public Mono<Solicitation> update(@RequestBody Solicitation solicitation,
            @PathVariable String id) {
        return this.solicitationService.update(solicitation, id);
    }

}
