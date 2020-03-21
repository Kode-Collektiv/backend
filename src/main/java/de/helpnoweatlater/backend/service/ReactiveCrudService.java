package de.helpnoweatlater.backend.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

public interface ReactiveCrudService<T, ID> {

    Mono<T> create(T t);

    Mono<T> retrieveById(final ID id);

    Flux<T> retrieveAll();

    Mono<T> update(T t, final ID id);

    Mono<T> updatePartial(T t, final ID id);

    void deleteById(final ID id);
}
