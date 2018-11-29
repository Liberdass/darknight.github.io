package forFun;

import java.util.Scanner;

public class Hanoit {
    static int count = 0;

    public static void hanoit(int n, char from, char helper, char to){
        if (n ==1){
            System.out.println("把"+from+"搬到"+to);
        }else {
            hanoit(n-1,from,to,helper);
            System.out.println("把"+from+"搬到"+to);
            hanoit(n-1,helper,from,to);
        }
        count++;
    }

    public static void main(String[] args) {
        hanoit(3,'A','B','C');
        System.out.println("搬了"+count+"次");
    }
}
