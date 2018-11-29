package javaNormal.thread.encodeing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Encoding {
    public static String password;
    public static void main(String[] args) {
        initPassword();
        encoding();
    }

    public static void encoding(){
        char[] cs = new char[3];
        char[] passchars = password.toCharArray();
        String str ="";
        loop:
        for(char a = 48; a < 123; a++){
            if( (a < 58) || (a >= 65 && a <= 90) || (a>=97 && a<= 122)) {
                cs[0]=a;
                for (char b = 48; b < 123; b++) {
                    if( (b < 58) || (b >= 65 && b <= 90) || (b>=97 && b<= 122) ) {
                        cs[1] = b;
                        for (char c = 48; c < 123; c++) {
                            if( (c < 58) || (c >= 65 && c <= 90) || (c>=97 && c<= 122) ) {
                                cs[2] = c;
                                str = new String(cs);
                                System.out.println("穷举法列举:"+str);
                                if (password.equals(str)) {
                                    System.out.println("密码是" + str);
                                    break loop;
                                }
                            }
                        }
                    }
                }
            }
        }
        final String writerStr = str;
        Thread thread = new Thread(){
            @Override
            public void run(){
                System.out.println("进入了线程");
                try(FileOutputStream fileInputStream = new FileOutputStream(new File("f:/test/111.txt"))){
                    fileInputStream.write(("密码是:"+writerStr).getBytes("UTF-8"));
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void initPassword(){
        Random random = new Random();
        int temp ;
        char[] cs = new char[3];
        for (int i = 0; i < 3; i++){
            temp = random.nextInt(3);
            if (temp == 0){
                cs[i] = (char)(random.nextInt(10)+48);
            }else if(temp == 1){
                cs[i] = (char)(random.nextInt(26)+65);
            }else {
                cs[i] = (char)(random.nextInt(26)+97);
            }
        }
        password = new String(cs);
    }
}
