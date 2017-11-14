package org.sample.state;

import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.Random;
import java.util.function.Supplier;

import org.sample.domain.Order;

@State(Scope.Benchmark)
public class OrderState {

    @Param({"100"})
    public int numberOfOrders;

    public Supplier<Order> randomExisting = new Supplier<Order>() {
        private final Random random = new Random();

        @Override
        public Order get() {
            return new Order(random.nextInt(numberOfOrders), 10, 10);
        }
    };

    public Supplier<Order> randomNonExisting = new Supplier<Order>() {
        public final Random random = new Random();

        @Override
        public Order get() {
            return new Order(random.nextInt(numberOfOrders) + numberOfOrders, 10, 10);
        }
    };
}
