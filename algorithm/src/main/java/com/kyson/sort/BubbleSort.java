package com.kyson.sort;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @title Bubble sort and related optimizations O(n^2)
 *
 * @author gaoqijian
 * @create 2019-12-25 18:48
 *
 * @description 基本思路：通过比较排序序列前后，依次比较相邻元素的值，若发现`逆序`则交换
 * 规则：
 *  1、一共进行 length-1 次大循环
 *  2、每一趟排序的次数逐渐减少
 *  3、若某一趟无交换，可提前结束
 */
public class BubbleSort {

    @Test
    public void testBubbleSort(){

        /**
         * 创建一个 80000 数据的随机数组 然后排序
         */
        int[] arr = new int[80000];
        for(int i=0; i<arr.length; i++){
            arr[i] = (int)(Math.random()*8000000); // 获得一个 [0, 80000] 的随机数组
        }

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = sdf.format(date);
        System.out.println("排序前时间" + date1Str);

        bubbleSort(arr);

        Date date2 = new Date();
        String date2Str = sdf.format(date2);
        System.out.println("排序后时间" + date2Str);
    }

    public int[] bubbleSortZuo(int[] arr){

        return arr;
    }

    public int[] bubbleSort(int[] arr){

        boolean flag = false;
        int tmp;

        for(int i=0; i<arr.length-1; i++){

            for(int j=0; j<arr.length-1-i; j++){

                //发现 逆序 交换
                if(arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                }
            }
            //若无交换 则跳出循环
            if(!flag){
                break;
            }else {
                flag = false;
            }

        }

        return arr;
    }

}
