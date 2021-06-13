package com.afaqy.service.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class SyncMethodCounter {

    int count = 0;
    static int staticCount = 0;

    synchronized void incSyncMethod() {
        count = count + 1;
    }

    static synchronized void incSyncStaticMethod() {
        staticCount = staticCount + 1;
    }

}

public class SyncMethodDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);

        SyncMethodCounter counter = new SyncMethodCounter();
        IntStream.range(0, 1000).forEach(count -> service.submit(counter::incSyncMethod));
        IntStream.range(0, 1000).forEach(count -> service.submit(SyncMethodCounter::incSyncStaticMethod));

        service.shutdown();
        service.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("Count: " + counter.count);
        System.out.println("Count: " + SyncMethodCounter.staticCount);
    }

}
