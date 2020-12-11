package com.example.app;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeterminantDeal extends Calculation implements Determinant {

    @Override
    public double Showfinallyanswer(double[][] determinant) {
        double result = 1;
        try {
            result = result * MathDeterminantCalculation(determinant);
        } catch (Exception e) {
            Log.e("结果", String.valueOf(result));
        }
        return result;
    }

    @Override
    public double DeterminantGet(String str,int count) {
        int i = 0;
        int k = 0;
        int g_1=0;
        double answer = 1;
        String[] strs = str.split(" ");
        int longth = strs.length;
        int hang_longth=longth/count;

        double[][] determinant = new double[longth][longth];
        try {
            for (int g = 0; g <= hang_longth - 1; g++) {
                determinant[i][g] = Double.parseDouble(strs[g]);
            }
            g_1=g_1+hang_longth;
            i++;
            for (; ; ) {
                if (i >= hang_longth) {
                    break;
                }
                String[] sts = str.split(" ");
                do {
                    determinant[i][k] = Double.parseDouble(sts[g_1]);
                    k++;
                    g_1++;
                }while (k<=hang_longth);
                i++;
                Log.e("KKKK", String.valueOf(k));
                k=0;
            }
            answer = Showfinallyanswer(determinant);
        } catch (Exception e) {
            DeterminantPaste( determinant, longth);
             Log.e("get", String.valueOf(answer));
        }
        return answer;
    }

    @Override
    public double MathDeterminantCalculation(double[][] value) throws Exception {
        if (value.length == 1) {
            return value[0][0];
        } else if (value.length == 2) {
            return value[0][0] * value[1][1] - value[0][1] * value[1][0];
        }

        double result = 1;
        for (int i = 0; i < value.length; i++) {
            //检查数组对角线位置的数值是否是0，如果是零则对该数组进行调换，查找到一行不为0的进行调换
            if (value[i][i] == 0) {
                value = ChangeDeterminantNoZero(value, i, i);
                result *= -1;
            }
            for (int j = 0; j < i; j++) {
                //让开始处理的行的首位为0处理为三角形式
                if (value[i][j] == 0) {
                    continue;
                }
                //如果要是要处理的行是0则和上面的一行进行调换
                if (value[j][j] == 0) {
                    double[] temp = value[i];
                    value[i] = value[i - 1];
                    value[i - 1] = temp;
                    result *= -1;
                    continue;
                }
                double ratio = -(value[i][j] / value[j][j]);
                value[i] = AddValue(value[i], value[j], ratio);
            }
        }
        return MathValue(value, result);
    }

    @Override
    // 计算行列式的结果
    public double MathValue(double[][] value, double result) throws Exception {
        for (int i = 0; i < value.length; i++) {
            if (value[i][i] == 0) {
                return 0;
            }
            result *= value[i][i];
        }
        return result;
    }

    @Override
    public double[] AddValue(double[] currentRow, double[] frontRow, double ratio) throws Exception {
        for (int i = 0; i < currentRow.length; i++) {
            currentRow[i] += frontRow[i] * ratio;
        }
        return currentRow;
    }

    @Override
    public double[][] ChangeDeterminantNoZero(double[][] determinant, int line, int row) throws Exception {
        for (int j = line; j < determinant.length; j++) {
            //进行行调换
            if (determinant[j][row] != 0) {
                double[] temp = determinant[line];
                determinant[line] = determinant[j];
                determinant[j] = temp;
                return determinant;
            }
        }
        return determinant;
    }
    public void DeterminantPaste(double[][] determinant, double longth) {
        int[][] determ = new int[(int) longth][(int) longth];
        for (int m = 0; m < longth; m++) {
            for (int k = 0; k < longth; k++) {
                determ[m][k] = (int) determinant[m][k];
                Log.e("数组",determ[m][k] + " ");
            }
        }
    }
}
