package javaBasic;

public class ExtendsRelation implements TestInterface{
    public void test(){
        TestInterface.super.test();//要使用接口的默认方法，必须使用  接口名.super.方法名
    }

    public void test2(){
        TestInterface.super.test2();//要使用接口的默认方法，必须使用  接口名.super.方法名
    }

    public static void main(String[] args) {
        ExtendsRelation er = new ExtendsRelation();
        er.test();
        er.test2();
    }
}
