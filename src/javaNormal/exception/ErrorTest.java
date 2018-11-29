package javaNormal.exception;

import java.io.File;
import java.io.FileInputStream;

public class ErrorTest {
    public static void main(String[] args) {
        int[] i = new int[5];
//        try{
//            System.out.println(i[5]);
//        }catch (Error error){
//            error.printStackTrace();
//        }
        try{
            fun();
        }catch (Throwable t){
            t.printStackTrace();
        }
    }

    public static void fun() throws Throwable{
        File f = new File("d:/LOL.exe");

        System.out.println("系统先尝试打开");
        new FileInputStream(f);
        System.out.println("系统打开成功");
    }
}
