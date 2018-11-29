package javaNormal.lists;

import javaNormal.lists.Node.TestNode;
import test.ArrayTest;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static int nums = 8000;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums; i++){
            list.add((int)(Math.random()*10000));
        }
        ArrayTest arrayTest = new ArrayTest(list);
        long startTime = System.currentTimeMillis();
        arrayTest.chooseSort();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

        long startTime2 = System.currentTimeMillis();
        arrayTest.bubbleSort();
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2-startTime2);

        TestNode tree = new TestNode();
        for(Integer i : list) {
            tree.add(i);
        }
        long startTime3 = System.currentTimeMillis();
        tree.sort();
        long endTime3 = System.currentTimeMillis();
        System.out.println(endTime3-startTime3);
    }
}
