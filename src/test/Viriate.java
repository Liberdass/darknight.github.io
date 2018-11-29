package test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Viriate {
    public static void get(final int i){
        System.out.println(i);
    }
    public static void main(String[] args){
        int row = 5;
        for(int i = 0; i<row;i++){//hang
            for(int j = 0;j<2*row-2-i;j++){//lie
                System.out.print(" ");
            }
            for (int j=0;j<2*i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        int i = 1;
        i+=++i;
        System.out.println(i);

    }
}
