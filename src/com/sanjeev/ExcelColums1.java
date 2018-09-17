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

    public static int printColumnNumber(String s){
        int sum=0; int pow=1;
        for(int i=s.length()-1;i>=0;i--){
            sum+= pow*(s.charAt(i)-'A'+1);
            pow =pow*26;
        }
        return sum;
    }



    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        String  str;
        cin.skip("\\s+");
        for (int l = 1; l <= test; l++) {
            str = cin.nextLine();
            System.out.println(printColumnNumber(str));
        }
    }
}
