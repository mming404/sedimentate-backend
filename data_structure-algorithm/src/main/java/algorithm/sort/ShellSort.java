package algorithm.sort;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

/**
 * @Description: TODO 希尔排序
 * @Author MiSinG
 * @Date 2023/9/20
 * @Version V1.0
 **/
public class ShellSort {

    public void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    private static final int N = 10; // 打印次数
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {

//        int[] arr = {64, 25, 12, 22, 11, 1, 4, 65, 34};
//        new ShellSort().shellSort(arr);
//        Arrays.stream(arr).forEach(System.out::println);
        /*
        15.代码题:有A、B、C三个线程，循环打印ABCABCABC...十次。每个线程打印时候其他线程不能打印。
         */

        Thread threadA = new Thread(new PrintThread("A", semaphoreA, semaphoreB));
        Thread threadB = new Thread(new PrintThread("B", semaphoreB, semaphoreC));
        Thread threadC = new Thread(new PrintThread("C", semaphoreC, semaphoreA));

        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class PrintThread implements Runnable {
        private String message;
        private Semaphore currentSemaphore;
        private Semaphore nextSemaphore;

        public PrintThread(String message, Semaphore currentSemaphore, Semaphore nextSemaphore) {
            this.message = message;
            this.currentSemaphore = currentSemaphore;
            this.nextSemaphore = nextSemaphore;
        }

        @Override
        public void run() {
            for (int i = 0; i < N; i++) {
                try {
                    currentSemaphore.acquire();
                    System.out.println(message);
                    nextSemaphore.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

}
