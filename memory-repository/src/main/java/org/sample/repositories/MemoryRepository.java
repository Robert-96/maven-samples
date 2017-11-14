package org.sample.repositories;

public interface MemoryRepository<T> {

    public void add(T element);
    public boolean contains(T element);
    public void remove(T element);
    public void clear();
}
