package org.sample.repositories.eclipse;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;

import org.sample.repositories.MemoryRepository;

public class MutableListBasedRepository<T> implements MemoryRepository<T> {

    private MutableList<T> mutableList;

    public MutableListBasedRepository() {
        mutableList = Lists.mutable.empty();
    }

    @Override
    public void add(T element) {
        mutableList.add(element);
    }

    @Override
    public boolean contains(T element) {
        return mutableList.contains(element);
    }

    @Override
    public void remove(T element) {
        mutableList.remove(element);
    }

    @Override
    public void clear() {
        mutableList.clear();
    }
}
