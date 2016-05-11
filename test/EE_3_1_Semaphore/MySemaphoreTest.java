package EE_3_1_Semaphore;

import org.junit.Test;

public class MySemaphoreTest {
    private static MySemaphore mySemaphore;

    @Test
    public void testParametrizedAcquire() throws Exception {
        int threads = 3;
        mySemaphore = new MySemaphore(5);

        for (int i = 0; i < threads; i++) {
            new Thread(new WorkerForParametrizedAcquire()).start();
        }

        while (WorkerForParametrizedAcquire.counter < threads) {
            Thread.sleep(3000);
        }
    }

    private static class WorkerForParametrizedAcquire implements Runnable {
        static int counter = 0;
        private int acquireIsNeeded = 5;

        @Override
        public void run() {
            try {
                mySemaphore.acquire(acquireIsNeeded);
                Thread.sleep(3000);
                mySemaphore.release(acquireIsNeeded);
                counter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}