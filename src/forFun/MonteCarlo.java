package forFun;

public class MonteCarlo {
    public static void main(String[] args) {
        double numInx = 0;
        double numIny = 0;
        double temp ;
        for(int i = 0; i < 10000000; i++){
            Double x = Math.random();
            Double y = Math.random();
            temp = x*x + y*y;
            if (temp< 1){
                numInx++;
            }else {
                numIny++;
            }
        }
        Double re = 4*numInx/(numIny+numInx);
        System.out.println("落在四分之一员内:"+numInx);
        System.out.println("落在单位正方形员内:"+numIny);
        System.out.println("pi估值:"+re);
    }
}
