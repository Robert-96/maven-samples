package org.sample;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import org.sample.domain.Order;
import org.sample.state.OrderState;
import org.sample.state.RepositoryState;


@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MemoryRepositoryAddTest {

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
    public void testAddRandomInexising(RepositoryState repositoryState, RandomNonExisting randomNonExisting) {
        repositoryState.orders.add(randomNonExisting.order);
    }

    @Benchmark
    public void testAddRandomExisting(RepositoryState repositoryState, RandomExisting existing) {
        repositoryState.orders.add(existing.order);
    }
}
