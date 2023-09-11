import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/9
 * @Version V1.0
 **/
public class TestVolatile {
    private volatile int a = 0;

    private Object obj = new Object();

    public void test() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    for (int i = 0; i < 10000; i++) {
                        a++;
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    for (int i = 0; i < 10000; i++) {
                        a--;
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

        TimeUnit.SECONDS.sleep(3);
        System.out.println(a);
    }

//    private static final ThreadLocal<Long> TIME = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        new TestVolatile().test();
    }
}
