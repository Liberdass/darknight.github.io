package javaNormal.io;

import common.Hero;

import java.io.*;

public class ObjectIOStream {
    public static void main(String[] args) {
        //创建一个Hero garen
        //要把Hero对象直接保存在文件上，务必让Hero类实现Serializable接口
        Hero[] heros = new Hero[10];
        for(int i = 0; i < heros.length; i++){
            heros[i] = new Hero("Hero "+i);
        }

        //准备一个文件用于保存该对象
        File f;
        f = new File("f:/111.txt");
        try(
                //创建对象输出流
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos =new ObjectOutputStream(fos);
                //创建对象输入流
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois =new ObjectInputStream(fis);
        ) {
            for(Hero hero:heros){
                oos.writeObject(hero);
                Hero hero2 = (Hero) ois.readObject();
                System.out.println(hero2.name + ":" + hero.hp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
