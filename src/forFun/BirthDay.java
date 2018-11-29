package forFun;

/** 多少人生日相同 */
public class BirthDay {
    public static void main(String[] args) {
        int[] births = new int[50];
        for (int i  = 0;i < births.length;i++){
            births[i] = (int)(Math.random()*365) + 1;
        }
        int[] is = sortBigToSmall(births);
        int count = 0;
        for(int i = 0; i < is.length-1; i++) {
            if(is[i] == is[i+1])
                count++;
            System.out.println(is[i]);
        }
        System.out.println(count);
    }

    public static int[] sortBigToSmall(int[] is){
        for(int i = 0; i < is.length; i++){
            for (int j = i+1; j < is.length; j++){
                int temp;
                if(is[i] < is[j]){
                    temp = is[j];
                    is[j] = is[i];
                    is[i] = temp;
                }
            }
        }
        return is;
    }
}
