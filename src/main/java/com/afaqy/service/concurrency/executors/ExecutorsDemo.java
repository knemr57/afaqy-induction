package com.afaqy.service.concurrency.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorsDemo demo = new ExecutorsDemo();

        // demo.executorDemo();

        // demo.executorServiceDemo();

        // demo.callableDemo();

        // demo.callableTimeoutsDemo();

        // demo.callableInvokeAllDemo();

        // demo.callableInvokeAnyDemo();
    }

    private void executorDemo() {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(runnable);
    }

    private void executorServiceDemo() {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(runnable);

        shutdownExecutor(executor);
    }

    private void callableDemo() throws ExecutionException, InterruptedException {
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch(InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());

        Integer result = future.get();

        System.out.println("future done? " + future.isDone());
        System.out.println("result: " + result);

        shutdownExecutor(executor);
    }

    private void callableTimeoutsDemo() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            } catch(InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        try {
            future.get(1, TimeUnit.SECONDS);
        } finally {
            shutdownExecutor(executor);
        }
    }

    private void callableInvokeAllDemo() throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(() -> "task1", () -> "task2", () -> "task3");

        List<Future<String>> futures = executor.invokeAll(callables);

        futures.stream().map(future -> {
            try {
                return future.get();
            } catch(Exception e) {
                throw new IllegalStateException(e);
            }
        }).forEach(System.out::println);

        shutdownExecutor(executor);
    }

    private void callableInvokeAnyDemo() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(callable("task1", 2), callable("task2", 1),
                callable("task3", 3));

        String result = executor.invokeAny(callables);
        System.out.println(result);

        shutdownExecutor(executor);
    }

    Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            /*if(result.equals("task2")) {
                throw new Exception();
            }*/
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }

    private void shutdownExecutor(ExecutorService executor) {
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch(InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if(!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

}
