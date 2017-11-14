package org.sample.repositories.standard;

import java.util.HashSet;

import org.sample.repositories.MemoryRepository;

public class HashSetBasedRepository<T> implements MemoryRepository<T> {

    private HashSet<T> hashSet;

    public HashSetBasedRepository() {
        hashSet = new HashSet<>();
    }

    @Override
    public void add(T element) {
        hashSet.add(element);
    }

    @Override
    public boolean contains(T element) {
        return hashSet.contains(element);
    }

    @Override
    public void remove(T element) {
        hashSet.remove(element);
    }

    @Override
    public void clear() {
        hashSet.clear();
    }
}
