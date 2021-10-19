package com.afaqy.service.concurrency.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsDemo {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorsDemo demo = new ScheduledExecutorsDemo();

        // demo.scheduledExecutorServiceDemo();

        // demo.scheduleAtFixedRateDemo();

        // demo.scheduleWithFixedDelayDemo();
    }

    private void scheduledExecutorServiceDemo() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1337);

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms%n", remainingDelay);
    }

    private void scheduleAtFixedRateDemo() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());

        int initialDelay = 0;
        int period = 1;
        executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
    }

    private void scheduleWithFixedDelayDemo() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            } catch(InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

        int initialDelay = 0;
        int delay = 1;
        executor.scheduleWithFixedDelay(task, initialDelay, delay, TimeUnit.SECONDS);
    }

}
