package algorithm.sort;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/3
 * @Version V1.0
 **/
public class InsertionSort {

    public int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr = {64, 25, 12, 22, 11};
        Arrays.stream(insertionSort.insertionSort(arr)).forEach(System.out::println);
    }
}
