package com.xxs.json.testCollection;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author van
 */
public class iteratorTest {
    public static void main(String[] args) {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 4, 6);
        Iterator<Integer> iterator = integers.iterator();
        int a = 1;
        while (integers.size() > 0 && a <3){
            while (iterator.hasNext()){
                iterator.next();
                iterator.remove();
                System.out.println("nei bu");
            }
            a ++;
            System.out.println("wai bu");
        }
        System.out.println("iteratorTest.main");
    }
}
