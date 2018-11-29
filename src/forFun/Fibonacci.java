package forFun;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static void main(String[] args) {
        int number = 0;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        System.out.println("第0个月0只");
        System.out.println("第1个月1只");
        for(int i = 2; i < 10; i++){
            list.add(list.get(i-2)+list.get(i-1));
            System.out.println("第"+i+"个月"+list.get(i)+"只");
        }
    }
}
