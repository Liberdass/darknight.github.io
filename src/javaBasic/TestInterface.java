package javaBasic;

public interface TestInterface {
    public int num = 1;
    default public void test(){
        System.out.println("接口默认方法");
    }

    default public void test2(){
        System.out.println("接口默认方法2");
    }
}
