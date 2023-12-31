package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/4
 * @Version V1.0
 **/
public class QuickSort {


    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
//        Random random = new Random();
//        int[] ints = new int[50];
//        for (int i = 0; i < 50; i++) {
//            ints[i] = random.nextInt();
//        }
        QuickSort quickSort = new QuickSort();
        int[] arr = {64, 25, 12, 22, 11, 23, 4, 16, 34};
        quickSort.quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
