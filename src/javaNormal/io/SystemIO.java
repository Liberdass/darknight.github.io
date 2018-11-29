package javaNormal.io;

import java.io.*;
import java.util.Scanner;
public class SystemIO {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入类的名称");
        String className=sc.nextLine();
        System.out.println("请输入属性的类型");
        String propertyType=sc.nextLine();
        System.out.println("请输入属性的名称");
        String propertyName=sc.nextLine();
        creat();
        File f=new File("f:/test.java");
        String s2="";
        try(BufferedReader br=new BufferedReader(new FileReader(f))){
            char[] c=new char[(int)f.length()];
            br.read(c);
            String s=new String(c);
            s2=s.replaceAll("@class@", className).replaceAll("@type@", propertyType).replaceAll("@property@",propertyName);
            System.out.println(s2);
        }catch(IOException e) {}
        try(BufferedWriter bf=new BufferedWriter(new FileWriter(f))){
            bf.write(s2);
            bf.flush();
        }catch(IOException e) {}
    }
    public static void creat() {
        File f=new File("f:/test.java");
        if(f.exists()==false)
            try {
                f.getParentFile().mkdirs();
                f.createNewFile();
            }catch(IOException e) {}
        String model = "public class @class@ {\n" +
                "    public @type@ @property@;\n" +
                "    public @class@() {\n" +
                "    }\n" +
                "    public void set@property@(@type@  @property@){\n" +
                "        this.@property@ = @property@;\n" +
                "    }\n" +
                "      \n" +
                "    public @type@  get@property@(){\n" +
                "        return this.@property@;\n" +
                "    }\n" +
                "}";
        System.out.println(model);
        try(PrintWriter pw=new PrintWriter(new FileWriter(f))){
            pw.write(model);
        }catch(IOException e) {}
    }
}
