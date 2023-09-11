package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/10
 * @Version V1.0
 **/
public class LockTest {

    private int i = 0;
    public void reentrantLockTest() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        lock.lock();
        try {
            for (int j = 0; j < 10000; j++) {
                i++;
            }
            System.out.println("ysmhhhhh");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

        System.out.println(Integer.parseInt("0111", 2));
    }

}
