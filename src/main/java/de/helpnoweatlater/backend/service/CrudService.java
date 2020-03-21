package de.helpnoweatlater.backend.service;

import java.util.Collection;

public interface CrudService<T, ID> {

    T create(T t);

    T retrieveById(final ID id);

    Collection<T> retrieveAll();

    T update(T t, final ID id);

    T updatePartial(T t, final ID id);

    void deleteById(final ID id);
}
