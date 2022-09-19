package com.grupo27.library.service;

import java.util.List;
import java.util.Optional;

public interface IEntityService<T> {
    T save(T t);
    List<T> findAll();
    Optional<T> findById(Long id);
    T update(T t);
    void delete(Long id);
}
