package com.vivek.multithreading.lock;
/*
You are working on a payment processing service.

Multiple threads process payments.
All threads must update a shared in-memory balance ledger.
During peak traffic, some threads wait too long for the lock and cause request timeouts.

The business requirement says:
A thread should wait at most 2 seconds to acquire the lock.
If it cannot acquire the lock, it should fail fast and return an error.

During application shutdown, threads should stop immediately and not remain blocked.

👉 Question

How would you design the locking logic using ReentrantLock to meet these requirements?

Specifically explain:

Which lock method you would use
Why synchronized is not suitable here
How your solution avoids long blocking and supports graceful shutdown
You can answer in plain English, pseudocode, or Java code.

 Difference between isLocked() and isHeldByCurrentThread()?
 isLocked() -> is locked by any thread
 isHeldByCurrentThread() ->  is locked by current thread


🧠 Final Timeline Summary
Thread	Event
employee2	Acquires lock
employee1	Times out, never acquires
employee2	Re-enters lock (hold count 2)
employee2	Unlocks inner lock
employee2	Unlocks outer lock


Employee1 does not acquire the lock because Employee2 holds it longer than Employee1’s timeout.
The solution is to either reduce the lock hold time, increase the timeout, use a fair lock, or implement a retry strategy depending on system requirements.

 */


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class GoldShopPaymentDesk {


    public void doPayment(ReentrantLock lock) {
        System.out.println("Employee Came for payment processing  : " + Thread.currentThread().getName());

        try {
            boolean isLockAcquired = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("Payment process Started with Employee : " + Thread.currentThread().getName());
            if (isLockAcquired) {
                System.out.println("Lock Acquired " + isLockAcquired + " by : " + Thread.currentThread().getName());
                Thread.sleep(3950);
                validatePayments(lock);
                System.out.println("Payment process Done with Employee : " + Thread.currentThread().getName());
            }

        } catch (Exception e) {
            System.out.println("Exception Occurred " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("Hold Count :" + lock.getHoldCount() + "  by : " + Thread.currentThread().getName());
            boolean isLockAcquired = lock.isHeldByCurrentThread();
            if (isLockAcquired) {
                lock.unlock();
                System.out.println("Lock Released : " + isLockAcquired + " by : " + Thread.currentThread().getName());
            }
        }

    }

    private void validatePayments(ReentrantLock lock) {
        try {
            lock.lock();
            boolean isLockAcquired = lock.isHeldByCurrentThread();
            if (isLockAcquired) {
                System.out.println("Payment verified with Employee : " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            System.out.println("Exception Occurred " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            boolean isLockAcquired = lock.isHeldByCurrentThread();
            System.out.println("Hold Count :" + lock.getHoldCount() + "  by : " + Thread.currentThread().getName());
            if (isLockAcquired) {
                lock.unlock();
                System.out.println("Lock Released : " + isLockAcquired + " by : " + Thread.currentThread().getName());
            }
        }
    }
}


public class ReentrantLockSolution {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);

        GoldShopPaymentDesk cashierOne = new GoldShopPaymentDesk();
        GoldShopPaymentDesk cashierTwo = new GoldShopPaymentDesk();

        Thread employee1 = new Thread(() -> cashierOne.doPayment(lock));
        employee1.setName("employee1");

        Thread employee2 = new Thread(() -> cashierTwo.doPayment(lock));
        employee2.setName("employee2");

        employee1.start();
        employee2.start();
    }
}
