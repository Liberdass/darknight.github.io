package common;

public class CommonTest {
    public static void main(String[] args) {
        ADHero h = new ADHero(){
            @Override
            public String toString() {
                return super.toString()+"匿名了哦";
            }
        };

        System.out.println(h);
    }
}
