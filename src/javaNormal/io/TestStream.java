package javaNormal.io;

import java.io.*;
import java.nio.charset.Charset;

public class TestStream {
    public static void main(String[] args) {
        File file = new File("f:/test/111.txt");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            char[] chars = new char[(int)file.length()];
            bufferedReader.read(chars);
            String str = new String(chars);
            System.out.println(str);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
