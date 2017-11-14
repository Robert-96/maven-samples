package org.sample.repositories.eclipse;

import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.sample.repositories.MemoryRepository;

public class UnifiedSetBasedRepository<T> implements MemoryRepository<T> {

    private UnifiedSet<T> unifiedSet;

    public UnifiedSetBasedRepository() {
        unifiedSet = new UnifiedSet<>();
    }

    @Override
    public void add(T element) {
        unifiedSet.add(element);
    }

    @Override
    public boolean contains(T element) {
        return unifiedSet.contains(element);
    }

    @Override
    public void remove(T element) {
        unifiedSet.remove(element);
    }

    @Override
    public void clear() {
        unifiedSet.clear();
    }
}
