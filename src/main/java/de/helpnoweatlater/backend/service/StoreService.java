package de.helpnoweatlater.backend.service;

import de.helpnoweatlater.backend.domain.Store;
import de.helpnoweatlater.backend.repository.StoreRepository;
import de.helpnoweatlater.backend.web.exception.EntityNotFoundException;
import de.helpnoweatlater.backend.web.exception.OperationNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

@Service
public class StoreService implements ReactiveCrudService<Store, String> {

    private final StoreRepository storeRepository;


    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Mono<Store> create(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Mono<Store> retrieveById(final String id) {
        return storeRepository.findById(id);
    }

    @Override
    public Flux<Store> retrieveAll() {
        return storeRepository.findAll();
    }

    @Override
    public Mono<Store> update(Store store, final String id) {
        // TODO
        throw new OperationNotSupportedException(HttpStatus.NOT_FOUND, OperationNotSupportedException.DEFAULT_EXCEPTION_MESSAGE);
    }

    @Override
    public Mono<Store> updatePartial(Store store, final String id) {
        // TODO
        throw new OperationNotSupportedException(HttpStatus.NOT_FOUND, OperationNotSupportedException.DEFAULT_EXCEPTION_MESSAGE);
    }

    @Override
    public void deleteById(final String id) {
        storeRepository.deleteById(id);
    }
}
