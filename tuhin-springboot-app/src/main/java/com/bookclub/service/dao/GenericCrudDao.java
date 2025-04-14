package com.bookclub.service.dao;

import java.util.List;

public interface GenericCrudDao<E,K> {

    List<E> list();
    E find(K key);

    void add(E entity);
    void update(E entity);
    boolean remove(E entity);
}
