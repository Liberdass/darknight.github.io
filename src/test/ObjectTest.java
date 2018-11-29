package test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class ObjectTest {
    public static Unsafe unsafe;

    static{
            try{
                 Field field = Unsafe.class.getDeclaredField("theUnsafe");
                 field.setAccessible(true);
                 unsafe = (Unsafe) field.get(null);
               }catch(Exception e) {
                  e.printStackTrace();
               }
          }

    public static void main(String[] args){
        String str1 = new String("str1");
        String str2 = new String("str2");
        String str3;

        System.out.println(str1.codePoints() + str1);
        System.out.println(System.identityHashCode(str1));
        System.out.println(str2.codePoints() + str2);
        System.out.println(System.identityHashCode(str2));
        str3 = str1;
        System.out.println(str3.codePoints() + str3);
        System.out.println(System.identityHashCode(str3));
        str1 = new String("str4");
        System.out.println(str1.codePoints() + str1);
        System.out.println(System.identityHashCode(str1));
    }
}
