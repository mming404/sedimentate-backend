package algorithm.sort;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/3
 * @Version V1.0
 **/
public class SelectionSort {


    public int[] selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            //初始化最小下表为0
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {//如果当前值小于min值 就交换min下表
                    minIndex = j;
                }
            }
            //进行交换
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] arr = {64, 25, 12, 22, 11};
        Arrays.stream(selectionSort.selectSort(arr)).forEach(System.out::println);
    }
}
