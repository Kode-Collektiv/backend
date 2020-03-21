package de.helpnoweatlater.backend.repository;

import de.helpnoweatlater.backend.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

}
