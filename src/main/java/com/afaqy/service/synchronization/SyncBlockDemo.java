package com.afaqy.service.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class SyncBlockCounter {

    int count = 0;
    static int staticCount = 0;

    final Object lock = new Object();

    void incSyncBlock() {
        synchronized(this) {
            count = count + 1;
        }
    }

    void incSyncBlockLock() {
        synchronized(lock) {
            count = count + 1;
        }
    }

    static void incSyncStaticBlock() {
        synchronized(SyncBlockCounter.class) {
            staticCount = staticCount + 1;
        }
    }

}

public class SyncBlockDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);

        SyncBlockCounter counter = new SyncBlockCounter();

        IntStream.range(0, 1000).forEach(count -> service.submit(counter::incSyncBlock));
        IntStream.range(0, 1000).forEach(count -> service.submit(counter::incSyncBlockLock));
        IntStream.range(0, 1000).forEach(count -> service.submit(SyncBlockCounter::incSyncStaticBlock));

        service.shutdown();
        service.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("Count: " + counter.count);
        System.out.println("Count: " + SyncBlockCounter.staticCount);
    }

}
