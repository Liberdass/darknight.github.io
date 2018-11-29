package javaNormal.io;

import java.io.*;
import java.nio.charset.Charset;

public class ChineseChar {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\Administrator\\Desktop\\chahao.txt");
        char[] cs = new char[(int)f.length()];
        try(InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(f), Charset.forName("UTF-8"));){
            inputStreamReader.read(cs);
            System.out.println("未处理UTF-8编码首位标识符的读取内容");
            System.out.println(new String(cs));
            System.out.println(cs[0]);
        }catch (IOException e){
            e.printStackTrace();
        }
        char[] csCopy = new char[cs.length - 1];
        System.arraycopy(cs,1,csCopy,0,csCopy.length);
        System.out.println(new String(csCopy));

//        int[] hexInts = new int[]{0xE5,0xB1,0x8C};
//        byte[] intByte = new byte[3];
//        for(int i =0; i< hexInts.length;i++){
//            System.out.println(hexInts[i]);
//            intByte[i] = (byte)hexInts[i];
//        }
//        String str = "";
//        try{
//            str = new String(intByte,"UTF-8");
//            System.out.println(str);
//        }catch (UnsupportedEncodingException e){
//            e.printStackTrace();
//        }

//        File f = new File("C:\\Users\\Administrator\\Desktop\\chahao.txt");
//        System.out.println("默认编码方式:"+ Charset.defaultCharset());
//        //FileReader得到的是字符，所以一定是已经把字节根据某种编码识别成了字符了
//        //而FileReader使用的编码方式是Charset.defaultCharset()的返回值，如果是中文的操作系统，就是GBK
        //在ide中根据ide默认编码改变
//        try (FileReader fr = new FileReader(f)) {
//            char[] cs = new char[(int) f.length()];
//            fr.read(cs);
//            System.out.printf("FileReader会使用默认的编码方式%s,识别出来的字符是：%n",Charset.defaultCharset());
//            System.out.println(new String(cs));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //FileReader是不能手动设置编码方式的，为了使用其他的编码方式，只能使用InputStreamReader来代替
//        //并且使用new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8")); 这样的形式
//        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f),Charset.forName("GBK"))) {
//            char[] cs = new char[(int) f.length()];
//            isr.read(cs);
//            System.out.printf("InputStreamReader 指定编码方式GBK,识别出来的字符是：%n");
//            System.out.println(new String(cs));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
