package org.example.patterns.structural.proxy;

public class ProxyLock implements LockingSystem {
    private final LockingSystem lock = new Lock();

    @Override
    public void open() {
        System.out.println("Additional operations...");
        lock.open();
    }

    @Override
    public void close() {
        lock.close();
    }
}
