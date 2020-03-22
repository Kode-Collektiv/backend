package de.helpnoweatlater.backend.store;

import de.helpnoweatlater.backend.common.ReactiveCrudService;
import de.helpnoweatlater.backend.common.OperationNotSupportedException;
import org.reactivestreams.Subscriber;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Mono<Store> retrieve(final String id) {
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
    public Mono<Void> deleteById(final String id) {
        return storeRepository.deleteById(id);
    }
}
