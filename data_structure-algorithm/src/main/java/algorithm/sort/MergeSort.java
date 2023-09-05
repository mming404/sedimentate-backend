package algorithm.sort;

import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;

import java.util.Arrays;

/**
 * @Description: TODO 归并排序
 * @Author MiSinG
 * @Date 2023/9/5
 * @Version V1.0
 **/
public class MergeSort {


    public void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            //找中间点
            int mid = (left + right) / 2;
            //递归划分左边
            mergeSort(arr, temp, left, mid);
            //递归划分右边
            mergeSort(arr, temp, mid + 1, right);
            //合并已经排序的部分
            merge(arr, temp, left, mid, right);
        }
    }

    public void merge(int[] arr, int[] tempArr, int left, int mid, int right) {
        //标记左半边第一个未排序的元素
        int l = left;
        //标记右半边第一个未排序的元素
        int r = mid + 1;
        //临时数组的下标
        int pos = left;
//        int[] tempArr = new int[right - left + 1];
        //合并
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                tempArr[pos++] = arr[l++];
            } else {
                tempArr[pos++] = arr[r++];
            }
        }
        //合并左半区剩余元素
        while (l <= mid) {
            tempArr[pos++] = arr[l++];
        }
        //合并右半区剩余元素
        while (r <= right) {
            tempArr[pos++] = arr[r++];
        }
        //把临时数组中合并后的元素复制回去

        pos = left; // 重置pos
        while (pos <= right) {
            arr[pos] = tempArr[pos];
            pos++;
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {64, 25, 12, 22, 11, 23, 4, 16, 34};
        mergeSort.mergeSort(arr, new int[arr.length], 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);

    }
}
