package com.sanjeev;

import java.util.Scanner;

/**
 * Created by Sanjeev Guglani
 */
public class ExcelColums1 {

    public static String printColumnName(int num) {
        String str = "";
        while (num != 0) {
            int temp = num % 26;
            if (temp == 0) {
                str = 'Z'+str;
                num = (num / 26) - 1;
            } else {
                str = (char)('A' + temp - 1)+str;
                num = num / 26;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        int  sum;
        for (int l = 1; l <= test; l++) {
            sum = cin.nextInt();
            System.out.println(printColumnName(sum));
        }
    }
}
