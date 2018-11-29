package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Millionaire {
    public float property;//total property
    public float incomePerMonth;//
    public float extraIncome;
    public float salaty;
    public float spending;
    public float houseRent;//per month
    public float incidentalFee;//chaos fee per month
    public float boardWagesPerDay;//eat cost
    public float extraSpending;
    public float profit;
    public float yieldRatePerMonth;
    public int dayInMonth;
    public static int months;

    public static void main(String[] args){
        Millionaire millionaire = new Millionaire();
        millionaire.init();
        System.out.println("月份\t当月工资\t额外收入\t花销\t投资收益\t当前总资产");
        for (months = 1;months <13 ; months++){
            millionaire.monthInit();
            String grid = "%d\t%f\t%f\t%f\t%f\t%f\n";
            System.out.printf(grid,months,millionaire.salaty,millionaire.extraIncome,millionaire.getSpending(2018,months),millionaire.getprofit(),millionaire.property);
//            System.out.printf(grid,months,millionaire.salaty,millionaire.extraIncome,millionaire.getSpending(),millionaire.getprofit(),millionaire.property);
//            System.out.format(grid,months,millionaire.salaty,millionaire.extraIncome,millionaire.getSpending(),millionaire.getprofit(),millionaire.property);
//            System.out.println(months+"\t\t"+millionaire.salaty+"\t\t"+millionaire.extraIncome+"\t\t"+millionaire.getSpending()+"\t\t"+millionaire.getprofit()+"\t\t"+millionaire.property);
        }
        millionaire.init();
        System.out.println("月份\t当月工资\t额外收入\t花销\t投资收益\t当前总资产");
        for (months = 1;months <13 ; months++){
            millionaire.monthInit();
            String grid = "%d\t%f\t%f\t%f\t%f\t%f\n";
//            System.out.printf(grid,months,millionaire.salaty,millionaire.extraIncome,millionaire.getSpending(2018,months),millionaire.getprofit(),millionaire.property);
            System.out.printf(grid,months,millionaire.salaty,millionaire.extraIncome,millionaire.getSpending(),millionaire.getprofit(),millionaire.property);
//            System.out.format(grid,months,millionaire.salaty,millionaire.extraIncome,millionaire.getSpending(),millionaire.getprofit(),millionaire.property);
//            System.out.println(months+"\t\t"+millionaire.salaty+"\t\t"+millionaire.extraIncome+"\t\t"+millionaire.getSpending()+"\t\t"+millionaire.getprofit()+"\t\t"+millionaire.property);
        }

    }
    public void init(){
        property = 0;
        extraIncome = 0;
        salaty = 5000;
        incidentalFee = 500;
        houseRent = 1500;
        boardWagesPerDay = 50;
        yieldRatePerMonth = 0.003f;
    }
    public void monthInit(){
        property = getProperty();
    }
//每月花费
    public float getSpending(int year,int monthNo){
        spending = houseRent + incidentalFee + boardWagesPerDay*getDayInMonth(year,monthNo) + extraSpending;
        return spending;
    }
    public float getSpending(){
        spending = houseRent + incidentalFee + boardWagesPerDay*getDayThisMonth() + extraSpending;
        return spending;
    }
//每月收入
    public float getIncomePerMonth(){
        incomePerMonth = salaty + extraIncome +getprofit();
        return incomePerMonth;
    }
//profit 利润
    public float getprofit(){
        profit = property * yieldRatePerMonth;
        return profit;
    }
//每月剩余
    public float getRestPerMonth(){
        float rest = getIncomePerMonth()-getSpending();
        return rest;
    }
//总资产
    public float getProperty(){
        property += getRestPerMonth();
        return property;
    }

    public int getDayInMonth(int year,int monthNo){
        if(monthNo == 2) {
            if (year % 4 == 0) {
                dayInMonth = 29;
                if (year % 100 == 0) {
                    dayInMonth = 28;
                }
            }
        }else if(monthNo == 1|| monthNo == 3 || monthNo == 5 || monthNo == 7||monthNo == 8||monthNo == 10||monthNo == 12){
            dayInMonth = 31;
        }else {
            dayInMonth = 30;
        }
        return dayInMonth;
    }

    public int getDayThisMonth(){
        Date days = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(days);
        String[] ds =new String[3];
        ds=date.split("-");
        int year = Integer.valueOf(ds[0]);
        int monthNo = Integer.valueOf(ds[1]);
        dayInMonth = this.getDayInMonth(year,monthNo);
        return dayInMonth;
    }
}
