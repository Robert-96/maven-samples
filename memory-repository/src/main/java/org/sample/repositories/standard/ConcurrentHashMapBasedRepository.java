package org.sample.repositories.standard;

import java.util.Map;

import org.sample.repositories.MemoryRepository;

public class ConcurrentHashMapBasedRepository<T> implements MemoryRepository<T> {

    private Map<T, Boolean> concurrentMap;


    @Override
    public void add(T element) {
        concurrentMap.put(element, true);
    }

    @Override
    public boolean contains(T element) {
        return concurrentMap.containsKey(element);
    }

    @Override
    public void remove(T element) {
        concurrentMap.remove(element);
    }

    @Override
    public void clear() {
        concurrentMap.clear();
    }
}
