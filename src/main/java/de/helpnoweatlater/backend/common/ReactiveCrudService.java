package de.helpnoweatlater.backend.common;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

public interface ReactiveCrudService<T, ID> {

    Mono<T> create(T t);

    Mono<T> retrieve(final ID id);

    Flux<T> retrieveAll();

    Mono<T> update(T t, final ID id);

    Mono<T> updatePartial(T t, final ID id);

    Mono<Void> deleteById(final ID id);
}
