package org.sample.repositories.eclipse;

import org.eclipse.collections.impl.list.mutable.FastList;

import org.sample.repositories.MemoryRepository;

public class FastListBasedRepository<T> implements MemoryRepository<T> {

    private FastList<T> fastList;

    public FastListBasedRepository() {
        fastList = new FastList<>();
    }

    @Override
    public void add(T element) {
        fastList.add(element);
    }

    @Override
    public boolean contains(T element) {
        return fastList.contains(element);
    }

    @Override
    public void remove(T element) {
        fastList.remove(element);
    }

    @Override
    public void clear() {
        fastList.clear();
    }
}
