package lock;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/14
 * @Version V1.0
 **/
public class ReentrantLockTest {
    private static final int N = 100;

    private static final CountDownLatch lock  = new CountDownLatch(N);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 1; i <= N; i++) {
            pool.execute(new People(i,lock));
        }
        lock.await();
        System.out.println("发车！！");
    }

    static class People implements Runnable{
        private int num;

        private CountDownLatch lock;

        public People(int num, CountDownLatch lock) {
            this.num = num;
            this.lock = lock;
        }
        @Override
        public void run() {
            System.out.println("第"+num+"到了");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.countDown();
        }
    }



}
