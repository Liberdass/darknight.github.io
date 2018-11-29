package test;

import java.util.ArrayList;
import java.util.List;
//                        0         1                               2
//abc三个冈布奥 c年纪比剑士i大 a跟勇者j年纪不同 勇者比b小 请问a是谁? wuyi k
public class MagicJuniorQuestion {
    public static void main(String[] args){
        String A = "wuyi";
        String B = "yongshi";
        String C = "jianshi";
        List<String> list = new ArrayList<>();
        for(int i = 0; i<3 ; i++){
            for(int j = 0; j<3 ; j++){
                for( int k = 0; k<3 ; k++){
                    if( (k>i && (i!=j|| k!=j) &&( j < i|| j<k) ) || (j>i && (i!=j|| k!=j) &&( j < i|| j<k))){
                        list.add(String.valueOf(i)+String.valueOf(j)+String.valueOf(k));
                    }
                }
            }
        }
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }
}
