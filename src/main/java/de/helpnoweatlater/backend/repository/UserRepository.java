package de.helpnoweatlater.backend.repository;

import de.helpnoweatlater.backend.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
