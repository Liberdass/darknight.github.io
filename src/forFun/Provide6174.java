package forFun;

public class Provide6174 {
    public static void main(String[] args) {
        for(int kkk = 0; kkk<100;kkk++) {
            int[] num = new int[4];
            num = getSingleRandomNum(num[0], num[1], num[2], num[3]);
            int bigNum = 0, smaNum = 0;
            int[] tempNum = new int[num.length];
            tempNum = num;
            int temp2 = 0;
            for (int i = 0; i < 10; i++) {
                bigNum = groupNumber(sortBigToSmall(tempNum));
                smaNum = groupNumber(sortSmallToBig(tempNum));
                int temp = bigNum - smaNum;
                tempNum = getints(temp);
                if (temp == temp2) {
                    System.out.println("用了" + i + "次,值为" + groupNumber(num));
                    break;
                }
                temp2 = temp;
            }
        }
    }

    public static int[] getSingleRandomNum(Integer... integers){
        int[] is = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            is[i] = (int)(Math.random() * 10);
        }
        return is;
    }

    public static int groupNumber(int[] is){
        int gentle = 0;
        for (int i = 0; i < is.length; i++) {
            gentle += is[is.length-i-1] * Math.pow(10,i);
        }
        return gentle;
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

    public static int[] sortSmallToBig(int[] is){
        for(int i = 0; i < is.length; i++){
            for (int j = i+1; j < is.length; j++){
                int temp;
                if(is[i] > is[j]){
                    temp = is[j];
                    is[j] = is[i];
                    is[i] = temp;
                }
            }
        }
        return is;
    }

    public static int[] getints(int is){
        String str = String.valueOf(is);
        char[] cs = str.toCharArray();
        int[] ints = new int[cs.length];
        for (int i = 0; i<cs.length; i++) {
            ints[i] = Integer.parseInt(String.valueOf(cs[i]));
        }
        return ints;
    }

}
