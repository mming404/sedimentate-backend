package algorithm.sort;

import java.util.Arrays;

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

    public static void main(String[] args) {

        int[] arr = {64, 25, 12, 22, 11, 1, 4, 65, 34};
        new ShellSort().shellSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

}
