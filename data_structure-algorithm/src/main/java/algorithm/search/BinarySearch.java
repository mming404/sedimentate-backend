package algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/7/27
 * @Version V1.0
 **/
public class BinarySearch {

    static List<List<Integer>> h;


    public static void main(String[] args) {

//        h.add(new ArrayList<>());
//        Stack<Object> objects = new Stack<>();
//        objects.s
//        List<Object> collect = new ArrayList<>(objects);
//        int[] arr = new int[]{5,7,-24,12,13,2,3,12,5,6,35};
//        System.out.println(lengthOfLIS(arr));
//        int i = binarySearchBasic(arr, 878);
//        if (i !=-1){
//            System.out.println("找到了 为："+i);
//        }else{
//            System.out.println("没找到");
//        }
//        System.out.println("更改了name");
    }

    public static int binarySearchBasic(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (arr[m] > target) {
                j = m - 1;
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public void test() {
        System.out.println("sssss");
    }

    public static int lengthOfLIS(int[] nums) {
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);

        for (int i = 0; i < nums.length - 1; i++) {
            int flag = nums[i];
            int pre = nums[i];
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[j + 1] > flag) {
                    pre = flag;
                    flag = nums[j + 1];
                    count[i]++;
                } else if (nums[j + 1] < flag && nums[j + 1] > pre) {
                    flag = nums[j + 1];
                }
            }
        }
        return Arrays.stream(count).max().getAsInt();
    }



}
