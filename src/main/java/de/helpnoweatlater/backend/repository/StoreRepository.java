package de.helpnoweatlater.backend.repository;

import de.helpnoweatlater.backend.domain.Store;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StoreRepository extends ReactiveMongoRepository<Store, String> {

}
