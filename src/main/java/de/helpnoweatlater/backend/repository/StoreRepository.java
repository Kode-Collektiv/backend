package de.helpnoweatlater.backend.repository;

import de.helpnoweatlater.backend.domain.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository<Store, String> {

}
