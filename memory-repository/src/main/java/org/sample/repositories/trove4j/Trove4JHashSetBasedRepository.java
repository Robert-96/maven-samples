package org.sample.repositories.trove4j;

import org.sample.repositories.MemoryRepository;
import gnu.trove.set.hash.THashSet;

public class Trove4JHashSetBasedRepository<T> implements MemoryRepository<T> {

    private THashSet<T> tHashSet;

    public Trove4JHashSetBasedRepository() {
        tHashSet = new THashSet<>();
    }

    @Override
    public void add(T element) {
        tHashSet.add(element);
    }

    @Override
    public boolean contains(T element) {
        return tHashSet.contains(element);
    }

    @Override
    public void remove(T element) {
        tHashSet.remove(element);
    }

    @Override
    public void clear() {
        tHashSet.clear();
    }
}
