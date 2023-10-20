package algorithm.sort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/20
 * @Version V1.0
 **/
public class SleepSort {
    private void sleepSort(int[] nums) {
            // 线程数组。工厂
        Thread[] threads = new Thread[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 每一个数字创建一个线程。
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(num);// 休眠时间。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(num + "，");
            });
        }
        // 启动所有线程。
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
//        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11, 1, 4, 65, 34};
        new SleepSort().sleepSort(arr);
    }

}
