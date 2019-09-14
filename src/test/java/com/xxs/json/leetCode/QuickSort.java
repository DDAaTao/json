package com.xxs.json.leetCode;

/**
 * @author van
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] list = new int[]{3,1,4,2,5,7,3,3,3,12,54,23,4,3,2};
        // failureQuickSort(list, 0, list.length -1);
        sysList(list);
    }
    /**
     * 使用三相切分处理重复数据问题
     * */



    private static void failureQuickSort(int[] list, int begin, int end){
        if (begin == end || end <= 1 || begin > end){
            return;
        }
        int flag = end ;
        for (int i = begin; i < end ; i++){
            if (i == flag){
                    swap(list, flag, end);
                    sysList(list);
                System.out.println();
                System.out.println("i = " + i);
                failureQuickSort(list, begin, i - 1 );
                failureQuickSort(list, i + 1, end);
            }
            if (list[i] >= list[end]){
                swap(list, i, flag - 1);
                flag --;
                i --;
            }

        }
    }

    private static void twoPointer(int[] list, int begin, int end){

        int left = begin;
        int right = end;
        while (true){

        }
    }

    private static void swap(int[] list, int a, int b){
        if (b == -1){
            System.out.println("QuickSort.swap");
        }
        int tmp = list[a];
        list[a] = list[b];
        list[b] = tmp;
    }
    private static void sysList(int[] list){
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
