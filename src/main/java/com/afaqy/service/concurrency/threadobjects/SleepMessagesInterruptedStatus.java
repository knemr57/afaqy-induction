package com.afaqy.service.concurrency.threadobjects;

public class SleepMessagesInterruptedStatus {

    public static void main(String[] args) {
        String[] importantInfo = {"Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too"};

        for(String s : importantInfo) {
            heavyCrunch(s);

            if(Thread.interrupted()) {
                // We've been interrupted: no more crunching.
                return;
                // OR
                // throw new InterruptedException();
            }
        }
    }

    private static void heavyCrunch(String s) {
        // Do heavy crunch
        System.out.println(s);
    }

}
