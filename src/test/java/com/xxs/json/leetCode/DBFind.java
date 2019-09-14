package com.xxs.json.leetCode;

/**
 * @author van
 */
public class DBFind {
    public static void main(String[] args) {
        int[] list = new int[]{1,3,4,2,5,7,3};
        System.out.println(getArrMax(list, list.length - 1));
    }

    private static int getArrMax(int[] list, int i){
        if (i == 0){
            return list[0];
        }else if (i == 1){
            return Math.max(list[0], list[1]);
        }else {
            int a = getArrMax(list, i - 2) + list[i];
            int b = getArrMax(list, i -1);
            return Math.max(a,b);
        }
    }
}
