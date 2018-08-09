package com.example.reactiveapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reactiveapplication.dao.SolicitationRepository;
import com.example.reactiveapplication.dao.entity.Solicitation;
import com.example.reactiveapplication.service.AbstractService;
import com.example.reactiveapplication.service.SolicitationService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SolicitationServiceImpl extends AbstractService<Solicitation, String> implements SolicitationService {

	@Autowired
	private SolicitationRepository solicitationRepository;

	@Override
	public Mono<Solicitation> create(Solicitation solicitation) {
		return this.solicitationRepository.insert(solicitation);
	}

	@Override
	public Mono<Solicitation> update(Solicitation solicitation, String id) {
		return findOne(id).doOnSuccess(findSolicitation -> {
			findSolicitation.setContent(solicitation.getContent());
			findSolicitation.setTitle(solicitation.getTitle());
			findSolicitation.setAuthor(solicitation.getAuthor());
			this.solicitationRepository.save(findSolicitation).subscribe();
		});
	}

	@Override
	public Flux<Solicitation> findAll() {
		return this.solicitationRepository.findAll();
	}

	@Override
	public Mono<Solicitation> findOne(String id) {
		return this.solicitationRepository.findByIdAndDeleteIsFalse(id)
				.switchIfEmpty(Mono.error(new Exception("No Solicitation found with id: " + id)));
	}

	@Override
	public Flux<Solicitation> findByTitle(String title) {
		return this.solicitationRepository.findByAuthorAndDeleteIsFalse(title)
				.switchIfEmpty(Mono.error(new Exception("No Solicitation found with title containing: " + title)));
	}

	@Override
	public Mono<Boolean> delete(String id) {
		return findOne(id).doOnSuccess(solicitation -> {
			solicitation.setDelete(true);
			this.solicitationRepository.save(solicitation).subscribe();
		}).flatMap(solicitation -> Mono.just(Boolean.TRUE));
	}

}
