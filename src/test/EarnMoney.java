package test;

import java.util.Scanner;

public class EarnMoney {
    private static final float GETVATE = 1.1f;//利率
    private static final float VATE = 1.05f;//利息率
    private static float singleSave ;//每天存的钱
    private static float singleCost ;//每天花的钱
    private static float singleGet ;//每天花的钱
    private static final float IWANT = 1000f;
    private static float singleBorrow;//每天借钱
    private static float singleNeed;//每天成本
    private static float totalSave;//总存钱
    private static float dayNeed = 0;// 需要天数

    public static void main(String[] args) {
        String flag="";//1每天借1000，2每天借到1000
        System.out.println("选择：1、每天借1000加上自己的钱做成本,2、每天借到1000的成本");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        if("1".equals(input) || "2".equals(input)){
            flag = input;
        }else{
            System.out.println("U input a wrong order");
        }
        if ("1".equals(flag)) {
            singleCost = 45f;
            getDayOnFlag1("1",singleCost);
        }
        if ("2".equals(flag)) {
            singleCost = 45f;
            getDayOnFlag2("2",singleCost);
        }else{
            return;
        }
        System.out.println("Need day: " + (int)dayNeed + " days");
    }

    public static void init(String flag){
        if("1".equals(flag)){
            singleBorrow = 1000f;//每天借钱
            singleNeed = singleBorrow+totalSave;//每天成本
            totalSave = 0;//总存钱
        }
        if("2".equals(flag)){
            singleBorrow = 1000f - totalSave;
            singleNeed = singleBorrow + totalSave;
            totalSave = 0;
        }
    }

    public static void getDayOnFlag1(String flag,float singleCost){
        int i = 0;
        for(; totalSave <= IWANT ; i++){
            init("1");
            singleGet = singleNeed * GETVATE - singleBorrow * VATE;
            singleSave = singleGet - singleCost;
            totalSave += singleSave;
            System.out.println("第"+i+"天: 存钱 "+singleSave+"; 花钱 "+singleCost+"; 目前存了 "+totalSave);
            System.out.println("           借钱 "+singleBorrow+"; 还钱 "+singleBorrow*VATE+"今日成本: "+singleNeed);
        }
        dayNeed = (float) i;
    }

    public static void getDayOnFlag2(String flag,float singleCost){
        int i = 0;
        for(; totalSave <= IWANT ; i++) {
            init("2");
            singleGet = singleNeed * GETVATE - singleBorrow * VATE;
            singleSave = singleGet - singleCost;
            totalSave += singleSave;
            System.out.println("第"+i+"天: 存钱 "+singleSave+"; 花钱 "+singleCost+"; 目前存了 "+totalSave);
            System.out.println("           借钱 "+singleBorrow+"; 还钱 "+singleBorrow*VATE+"今日成本: "+singleNeed);
        }
        dayNeed = (float) i;
    }
}


