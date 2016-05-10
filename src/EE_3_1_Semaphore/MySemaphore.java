package EE_3_1_Semaphore;

import java.util.Objects;

public class MySemaphore implements Semaphore {
    private volatile int permitsAvailable;
    private final Object lock;

    public MySemaphore(int permitsAvailable) {
        this.permitsAvailable = permitsAvailable;
        this.lock = new Object();
    }

    @Override
    public void acquire() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " checking available acquire.");

                int ACQUIRE = 1;
                if (tryAcquire(ACQUIRE)) {
                    System.out.println(Thread.currentThread().getName() + " was acquired.");
                    permitsAvailable--;
                    Thread.sleep(3000);
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + "is waiting.");
                    Thread.currentThread().wait(); ///
                    System.out.println(Thread.currentThread().getName() + "woke up");
                    Thread.sleep(1000);
                }
            }
        }
    }

    @Override
    public void acquire(int permits) throws InterruptedException {
        synchronized (lock) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " checking available acquire.");
                if (tryAcquire(permits)) {
                    System.out.println(Thread.currentThread().getName() + " was acquired.");
                    permitsAvailable -= permits;
                    Thread.sleep(5000);
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " is waiting.");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + " woke up.");
                    Thread.sleep(1000);
                }
            }
        }
    }

    private boolean tryAcquire(int perm) {
        return permitsAvailable - perm >= 0;
    }

    @Override
    public void release() {
        synchronized (lock) {
            if (permitsAvailable + 1 > 0) {
                permitsAvailable++;
                lock.notify();
                System.out.println("Threads was notified by " + Thread.currentThread().getName());
            } else {
                System.out.println("Threads did not notify, available permits: " + permitsAvailable);
            }
        }
    }

    @Override
    public void release(int permits) {
        synchronized (lock) {
            if (permitsAvailable + permits > 0) {
                permitsAvailable += permits;
                lock.notifyAll();
                System.out.println("All threads was notified by " + Thread.currentThread().getName());
            } else {
                System.out.println("Threads did not notify, available permits: " + permitsAvailable);
            }
        }
    }

    @Override
    public int getAvailablePermits() {
        return permitsAvailable;
    }
}