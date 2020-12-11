package com.example.app;

import java.util.Calendar;

public class 小V {
    Calendar tim = Calendar.getInstance();
    int year=tim.get(Calendar.YEAR);
    int day=tim.get(Calendar.DAY_OF_MONTH);
    int month= tim.get(Calendar.MONTH)+1;

    private String name="小v";
    private int age;
    private String sex="暂不透露";

  /*  public 小V(){
        this.age=year-2020+1;
        if (month==11&&day==12){
            System.out.println("今天是小V的"+(age-1)+"周岁生日哦");
        }
    }*/

    public double DeterminantCalculate(String h,int a){
        double anwer;
        Determinant determinant = new DeterminantDeal();
        anwer=determinant.DeterminantGet(h,a);
        return anwer;
    }

    public long  AccumlateCount(int number){
        long a=1;
        for (int i=1;i<=number;i++){ a=a*i;}
        return a;
    }

}
