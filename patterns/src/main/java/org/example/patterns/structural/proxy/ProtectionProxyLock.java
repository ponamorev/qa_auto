package org.example.patterns.structural.proxy;

public class ProtectionProxyLock implements LockingSystem {
    private final LockingSystem lock = new Lock();

    @Override
    public void open() {
        if (AdditionalOperations.isAuthenticated()) {
            lock.open();
        } else {
            System.out.println("Access denied...");
        }
    }

    @Override
    public void close() {
        lock.close();
    }
}
