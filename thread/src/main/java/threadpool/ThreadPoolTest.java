package threadpool;

import com.alibaba.druid.sql.ast.statement.SQLPrivilegeItem;

import java.util.concurrent.*;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/12
 * @Version V1.0
 **/
public class ThreadPoolTest {

    public void tssdasd() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                10,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.DiscardPolicy());

        executor.execute(() -> System.out.println("ysmshihhh"));
        Future<String> future = executor.submit(() -> "ysm回来了");

        for (int i = 0; i < 50; i++) {
            int finalI = i;
            executor.execute(()-> System.out.println("hhh"+ finalI));
        }
        System.out.println(executor.getTaskCount());
        System.out.println(future.get());

        executor.shutdown();
    }

    public void testExecutor(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("sss");
            }
        },10,TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new ThreadPoolTest().testExecutor();
    }
}
