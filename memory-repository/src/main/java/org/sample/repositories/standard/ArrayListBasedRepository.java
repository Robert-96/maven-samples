package org.sample.repositories.standard;

import java.util.ArrayList;

import org.sample.repositories.MemoryRepository;

public class ArrayListBasedRepository<T> implements MemoryRepository<T> {

    private ArrayList<T> list;

    public ArrayListBasedRepository() {
        list = new ArrayList<>();
    }

    @Override
    public void add(T element) {
        list.add(element);
    }

    @Override
    public boolean contains(T element) {
        return list.contains(element);
    }

    @Override
    public void remove(T element) {
        list.remove(element);
    }

    @Override
    public void clear() {
        list.clear();
    }
}

