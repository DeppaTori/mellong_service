package com.deppatori.mellong.service;

import java.util.Set;

public interface BaseService<T> {
    public Set<T> findAll();
    public T findOne(Long id);
    public T save(T t);
    public T update(Long id,T t);
    public void delete(Long id);
}
