package org.sample;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import org.sample.domain.Order;
import org.sample.state.OrderState;
import org.sample.state.RepositoryState;


@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MemoryRepositoryContainsTest {

    @State(Scope.Benchmark)
    public static class RandomExisting {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(OrderState orderState) {
            order = orderState.randomExisting.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepositoryState repositoryState) {
            repositoryState.orders.remove(order);
        }
    }

    @State(Scope.Benchmark)
    public static class RandomNonExisting {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(OrderState orderState) {
            order = orderState.randomNonExisting.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepositoryState repositoryState) {
            repositoryState.orders.remove(order);
        }
    }

    @Benchmark
    public void testContainsForExisting(RepositoryState repositoryState, RandomExisting randomExisting) {
        repositoryState.orders.contains(randomExisting.order);
    }

    @Benchmark
    public void testContainsForNonExisting(RepositoryState repositoryState, RandomNonExisting randomNonExisting) {
        repositoryState.orders.contains(randomNonExisting.order);
    }
}
