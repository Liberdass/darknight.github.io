package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest {
    static int NUMBER = 10000;
    List<Integer> list = new ArrayList<>();
    public ArrayTest(){
        init();
    }
    public ArrayTest(List<Integer> list){
        this.NUMBER = list.size();
        this.list = list;
    }
    public static void main(String[] args){
        //初始化
//        List<Integer> list = init();
        //选择排序
//        long start = System.currentTimeMillis();
//        for (int i=0;i<NUMBER;i++){
//            for(int j = i+1; j < NUMBER;j++){
//                int temp;
//                if(list.get(i) > list.get(j)){
//                    temp = list.get(i);
//                    list.set(i,list.get(j));
//                    list.set(j,temp);
//                }
//            }
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end-start);
//        list.clear();
//        list=init();
//        //冒泡排序
//        long start2 = System.currentTimeMillis();
//        for(int i = 0; i < NUMBER; i++){
//            for (int j = 0;j<NUMBER -1 ;j++){
//                int temp ;
//                if(list.get(j) > list.get(j+1)){
//                    temp = list.get(j+1);
//                    list.set(j+1,list.get(j));
//                    list.set(j,temp);
//                }
//            }
//        }
//        long end2 = System.currentTimeMillis();
//        System.out.println(end2-start2);
//        list.clear();
//
//        int[] a = new int[]{1,2,3,4,5};
//        int[] b = new int[]{0,0,0,0,0,6,7,8,9,10};
//        int[] c ;
//        System.arraycopy(a,0,b,0,5);
//        System.out.println(Arrays.toString(b));
    }
    public List<Integer> chooseSort(){
        for (int i=0;i<NUMBER;i++){
            for(int j = i+1; j < NUMBER;j++){
                int temp;
                if(list.get(i) > list.get(j)){
                    temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
        return list;
    }

    public List<Integer> bubbleSort() {
        for(int i = 0; i < NUMBER; i++){
            for (int j = 0;j<NUMBER -1 ;j++){
                int temp ;
                if(list.get(j) > list.get(j+1)){
                    temp = list.get(j+1);
                    list.set(j+1,list.get(j));
                    list.set(j,temp);
                }
            }
        }
        return list;
    }

    //初始化
    public void init() {
        for (int i = 0; i < NUMBER; i++) {
            list.add((int) (Math.random() * 10000));
        }
    }
}
