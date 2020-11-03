package org.example.patterns.structural.proxy;

public class LockRunner {
    public static void main(String[] args) {
        System.out.println("Simple implementation.");
        LockingSystem lockingSystem = new Lock();
        lockingSystem.open();
        lockingSystem.close();

        System.out.println("\nProxy implementation.");
        lockingSystem = new ProxyLock();
        lockingSystem.open();
        lockingSystem.close();

        System.out.println("\nProtection proxy implementation.");
        lockingSystem = new ProtectionProxyLock();
        AdditionalOperations.setAuthenticated(false);
        lockingSystem.open();
        System.out.println("After authentication..");
        AdditionalOperations.setAuthenticated(true);
        lockingSystem.close();

        System.out.println("\n\n");
        lockingSystem = new LazyProxyLock();
        System.out.println("There is no output above, because object hasn't been created yet");
        lockingSystem.open();
        lockingSystem.close();
    }
}
