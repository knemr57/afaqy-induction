package com.afaqy.service.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class Counter {

    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        setCount(getCount() + 1);
    }

}

public class RaceConditionDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);

        Counter counter = new Counter();
        IntStream.range(0, 1000).forEach(count -> service.submit(counter::increment));

        service.shutdown();
        service.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("Count: " + counter.getCount());
    }

}
