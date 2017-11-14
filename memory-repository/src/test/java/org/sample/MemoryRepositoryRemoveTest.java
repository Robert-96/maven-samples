package org.sample;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import org.sample.domain.Order;
import org.sample.state.OrderState;
import org.sample.state.RepositoryState;


@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MemoryRepositoryRemoveTest {

    @State(Scope.Benchmark)
    public static class RandomExisting {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(OrderState orderState) {
            order = orderState.randomExisting.get();
        }

        @TearDown(Level.Invocation)
        public void addOrder(RepositoryState repositoryState) {
            repositoryState.orders.add(order);
        }
    }

    @State(Scope.Benchmark)
    public static class RandomNonExisting {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(OrderState orderState) {
            order = orderState.randomNonExisting.get();
        }
    }

    @Benchmark
    public void testRemoveForExisting(RepositoryState repositoryState, MemoryRepositoryContainsTest.RandomExisting randomExisting) {
        repositoryState.orders.remove(randomExisting.order);
    }

    @Benchmark
    public void testRemoveForNonExising(RepositoryState repositoryState, MemoryRepositoryContainsTest.RandomNonExisting randomNonExisting) {
        repositoryState.orders.remove(randomNonExisting.order);
    }
}
