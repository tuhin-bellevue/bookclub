package com.bookclub.service;

import java.util.List;

public interface GenericDao<E,K> {

    List<E> list();
    E find(K key);

    List<E> list(K key);

    void add(E entity);
    void update(E entity);

    void remove(K key);

}
