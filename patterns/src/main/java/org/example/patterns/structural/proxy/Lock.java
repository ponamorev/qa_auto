package org.example.patterns.structural.proxy;

public class Lock implements LockingSystem {
    Lock() {
        System.out.println("Creating lock...");
    }

    @Override
    public void open() {
        System.out.println("Unlock");
    }

    @Override
    public void close() {
        System.out.println("Lock");
    }
}
