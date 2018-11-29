package test;

import java.util.ArrayList;
import java.util.List;

public class Outloop {
    public static void main(String[] args) {
        //huangjinfenshu
        float result=100;
        final float goldNum = 0.618f;
        int son = 0;
        int mother = 0;
        for(float i = 1;i<21; i++){
            for(float j = 1;j<21;j++){
                if(getSub(i/j,goldNum)<result){
                    result = getSub(i/j,goldNum);
                    son = (int)i;
                    mother = (int)j;
                }
            }
        }
        System.out.println(son+"    "+mother +"   "+ result);
    //shuixianshu
        int i,j,k;
        int threeNum;
        List<Integer> list = new ArrayList<>();
        for(i=1;i<10;i++){
            for (j=0;j<10;j++){
                for(k=0;k<10;k++){
                    if ((threeNum = (int)getThreeNum(i,j,k))== getCube(i)+getCube(j)+getCube(k)){
                        list.add(threeNum);
                    }
                }
            }
        }
        System.out.println(list);

        //xiaoxueti
        for(int xx = 0; xx < 15; xx++){
            for (int xy = 0; xy <15; xy++){
                for (int yx = 0; yx < 15; yx++){
                    for (int yy = 0; yy < 15; yy++){
                        if(xx+xy == 8 && yx - yy == 6 && xx + yx == 14 && xy + yy == 10){
                            System.out.println(" "+xx+" "+xy+" "+yx+" "+yy);
                        }
                    }
                }
            }
        }

    }

    public static float getSub(float a,float b){
        float res=Float.MAX_VALUE;
        if(a-b>0) {
            res = a - b;
        }else{
            res = b-a;
        }
        return  res;
    }

    public static float getCube(float num){
        return num*num*num;
    }
    public static int getThreeNum(int i,int j,int k){
        return i*100+j*10+k;
    }
}
