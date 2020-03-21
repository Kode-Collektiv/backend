package de.helpnoweatlater.backend.service;

import de.helpnoweatlater.backend.domain.Store;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class StoreService implements CrudService<Store, UUID> {
    @Override
    public Store create(Store store) {
        return null;
    }

    @Override
    public Store retrieveById(final UUID uuid) {
        return null;
    }

    @Override
    public Collection<Store> retrieveAll() {
        return null;
    }

    @Override
    public Store update(Store store, final UUID uuid) {
        return null;
    }

    @Override
    public Store updatePartial(Store store, final UUID uuid) {
        return null;
    }

    @Override
    public void deleteById(final UUID uuid) {

    }
}
