package search;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/7/27
 * @Version V1.0
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,4,67,123,564,878,3424,56454};
        int i = binarySearchBasic(arr, 878);
        if (i !=-1){
            System.out.println("找到了 为："+i);
        }else{
            System.out.println("没找到");
        }
        System.out.println("更改了name");
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

    public void test(){
        System.out.println("sssss");
    }
}
