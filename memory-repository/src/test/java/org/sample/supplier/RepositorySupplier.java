package org.sample.supplier;

import java.util.function.Supplier;

import org.sample.domain.Order;
import org.sample.repositories.MemoryRepository;
import org.sample.repositories.eclipse.FastListBasedRepository;
import org.sample.repositories.eclipse.MutableListBasedRepository;
import org.sample.repositories.eclipse.UnifiedSetBasedRepository;
import org.sample.repositories.standard.ArrayListBasedRepository;
import org.sample.repositories.standard.ConcurrentHashMapBasedRepository;
import org.sample.repositories.standard.HashSetBasedRepository;
import org.sample.repositories.standard.TreeSetBasedRepository;
import org.sample.repositories.trove4j.Trove4JHashSetBasedRepository;


public enum RepositorySupplier implements Supplier<MemoryRepository<Order>> {

    // STANDARD:

    HASH_SET() {
        @Override
        public MemoryRepository<Order> get() {
            return new HashSetBasedRepository<>();
        }
    },

    TREE_SET() {
        @Override
        public MemoryRepository<Order> get() {
            return new TreeSetBasedRepository<>();
        }
    },

    ARRAY_LIST() {
        @Override
        public MemoryRepository<Order> get() {
            return new ArrayListBasedRepository<>();
        }
    },

    CONCURRENT_HASH_MAP() {
        @Override
        public MemoryRepository<Order> get() {
            return new ConcurrentHashMapBasedRepository<>();
        }
    },


    // ECLIPSE:

    FAST_LIST() {
        @Override
        public MemoryRepository<Order> get() {
            return new FastListBasedRepository<>();
        }
    },

    MUTABLE_LIST() {
        @Override
        public MemoryRepository<Order> get() {
            return new MutableListBasedRepository<>();
        }
    },

    UNIFIELF_SET() {
        @Override
        public MemoryRepository<Order> get() {
            return new UnifiedSetBasedRepository<>();
        }
    },

    // TROVE4J
    TROVE4J_HASH_SET() {
        @Override
        public MemoryRepository<Order> get() {
            return new Trove4JHashSetBasedRepository<>();
        }
    }

}
