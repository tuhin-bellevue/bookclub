package com.bookclub.service;

import java.util.List;

public interface GenericDao<E,K> {

    List<E> list();
    E find(K key);

    void add(E entity);
    void update(E entity);
    boolean remove(E entity);
}
