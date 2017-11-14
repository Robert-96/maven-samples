package org.sample.state;

import org.openjdk.jmh.annotations.*;

import org.sample.domain.Order;
import org.sample.repositories.MemoryRepository;
import org.sample.supplier.RepositorySupplier;

@State(Scope.Benchmark)
public class RepositoryState {

    @Param
    private RepositorySupplier repositorySupplier;

    public MemoryRepository<Order> orders;

    // Run before each Benchmark
    @Setup
    public void setUp(OrderState orderState) {
        orders = repositorySupplier.get();

        for (int i = 0; i < orderState.numberOfOrders; i++) {
            orders.add(new Order(i, 10, 10));
        }
    }

    // Run after each Benchmark
    @TearDown
    public void tearDown() {
        orders.clear();
    }
}