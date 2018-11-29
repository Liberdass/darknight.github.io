package javaNormal.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionTest {
    public static void main(String[] args) throws FileNotFoundException,ParseException {
        File f = new File("f:test.java");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            new FileInputStream(f);
//            System.out.println("Open successful");
//            Date d = sdf.parse("2018-09-29");
//            System.out.println(d);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("Open error");
//        } catch (ParseException e) {
//            e.printStackTrace();
//            System.out.println("Parsing exeption");
//        } finally {
//            System.out.println("final");
//        }

        int[] a = new int[10];
        try{
            System.out.println(a[10]);
        }catch (Throwable t){
            t.printStackTrace();
        }
    }
}
