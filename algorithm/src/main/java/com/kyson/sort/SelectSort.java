package com.kyson.sort;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gaoqijian
 * @title Select Sort
 * @create 2019-12-25 18:48
 * @description 基本思路：第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换，第二次同理从arr[1]~arr[n-1]中选最小，
 * 通过n-1次交换，完成排序
 */
public class SelectSort {

    @Test
    public void testSelectSort()
    {

        /**
         * 创建一个 80000 数据的随机数组 然后排序
         */
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 获得一个 [0, 80000] 的随机数组
        }

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = sdf.format(date);
        System.out.println("排序前时间" + date1Str);

        selectSort(arr);

        Date date2 = new Date();
        String date2Str = sdf.format(date2);
        System.out.println("排序后时间" + date2Str);
    }

    /**
     * 外层循环：i 代表"当前要填的位置"
     * 假设数组有 5个元素，下标是 0,1,2,3,4 外层循环为什么是 length - 1（即4）
     * 当前面4个位置都填好了，第5个位置（下标4）的那个数，必然是最大的
     *
     * 内层循环是 往后扫描，找最小值，它需要扫到数组真正的末尾，否则会漏掉元素
     * @param arr
     */
    public void selectSort(int[] arr)
    {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);

        }
    }

    public static void swap(int[] arr, int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
