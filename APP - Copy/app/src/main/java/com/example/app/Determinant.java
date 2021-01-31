package com.example.app;

public interface Determinant {
    double Showfinallyanswer(double[][] determinant);
    double DeterminantGet(String s,int a);//完整功能接口 单接口完成完整功能
    double MathDeterminantCalculation(double[][] value) throws Exception;
    double MathValue(double[][] value, double result) throws Exception;
    double[] AddValue(double[] currentRow,double[] frontRow, double ratio) throws Exception;
    double[][] ChangeDeterminantNoZero(double[][] determinant,int line,int row) throws Exception;

}
