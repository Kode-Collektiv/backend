package de.helpnoweatlater.backend.repository;

import de.helpnoweatlater.backend.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StoreRepository extends JpaRepository<Store, UUID> {

}
