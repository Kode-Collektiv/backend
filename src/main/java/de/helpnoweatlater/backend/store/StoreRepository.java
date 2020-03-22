package de.helpnoweatlater.backend.store;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StoreRepository extends ReactiveMongoRepository<Store, String> {

}
