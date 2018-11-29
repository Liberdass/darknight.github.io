package javaNormal.io;

import java.io.*;

public class BufferedIO {
    public static void main(String[] args) {
        File f = new File("f:/111.txt");
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));){
            while (true){
                String str = bufferedReader.readLine();
                if(null == str){
                    break;
                }
                System.out.println(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
//        //惊人的发现，写入的格式会影响到文件编码格式，这里写入GBK则文件编码变成GBK
//        try(PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(f),"UTF-8"))){
//            String str1 = "叼";
//            String str2 = "得";
//            String str3 = "一";
//            printWriter.write(str1);
//            printWriter.write(str2);
//            printWriter.write(str3);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }
}
