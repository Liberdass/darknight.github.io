package baidu;

import java.util.Scanner;

public class HextoDec {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.next());
        int add = 0;
        for (int i = 0; i < num; i++){
            add += Integer.valueOf(h2D(s.next()));
        }
        System.out.println(add);
    }

    public static String h2D(String s) {
        int intString = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if ('A' == cs[i]) {
                intString += 10 * Math.pow(16, cs.length-i-1);
            } else if ('B' == cs[i]) {
                intString += 11 * Math.pow(16, cs.length-i-1);
            } else if ('C' == cs[i]) {
                intString += 12 * Math.pow(16, cs.length-i-1);
            } else if ('D' == cs[i]) {
                intString += 13 * Math.pow(16, cs.length-i-1);
            } else if ('E' == cs[i]) {
                intString += 14 * Math.pow(16, cs.length-i-1);
            } else if ('F' == cs[i]) {
                intString += 15 * Math.pow(16, cs.length-i-1);
            } else {
                intString += (Integer.valueOf(cs[i])-48) * Math.pow(16, cs.length-i-1);
            }
        }
        return String.valueOf(intString);
    }
}
