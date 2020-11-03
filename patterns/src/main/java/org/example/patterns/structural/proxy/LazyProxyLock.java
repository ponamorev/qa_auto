package org.example.patterns.structural.proxy;

import java.util.Objects;

public class LazyProxyLock implements LockingSystem {
    private LockingSystem lock;

    @Override
    public void open() {
        if (Objects.isNull(lock)) {
            lock = new ProtectionProxyLock();
        }
        lock.open();
    }

    @Override
    public void close() {

    }
}
