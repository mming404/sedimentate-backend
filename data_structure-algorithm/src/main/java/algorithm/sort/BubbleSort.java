package algorithm.sort;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/3
 * @Version V1.0
 **/
public class BubbleSort {


    public int[] bubbleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int a = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = a;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 8, 2, 5, 7, 2, 3};
        BubbleSort bubbleSort = new BubbleSort();
        Arrays.stream(bubbleSort.bubbleSort(ints)).forEach(System.out::println);
    }

}
