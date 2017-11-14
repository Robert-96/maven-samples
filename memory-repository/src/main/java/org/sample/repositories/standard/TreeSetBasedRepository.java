package org.sample.repositories.standard;

import java.util.TreeSet;

import org.sample.repositories.MemoryRepository;

public class TreeSetBasedRepository<T> implements MemoryRepository<T> {

    private TreeSet<T> treeSet;

    public TreeSetBasedRepository() {
        treeSet = new TreeSet<>();
    }

    @Override
    public void add(T element) {
        treeSet.add(element);
    }

    @Override
    public boolean contains(T element) {
        return treeSet.contains(element);
    }

    @Override
    public void remove(T element) {
        treeSet.remove(element);
    }

    @Override
    public void clear() {
        treeSet.clear();
    }
}