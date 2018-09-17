package com.sanjeev;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Sanjeev Guglani
 */
public class MinCoin {

    public static int mincoin(int arr[],int sum) {
       return mincoin(arr,0,sum);
    }

    public static int mincoin(int arr[],int k,int sum){
        if (sum == 0) {
            return 0;
        } else if (sum < 0 || k == arr.length) {
            return -1;
        } else {
            int x=mincoin(arr, k, sum - arr[k]);
            if(x!=-1){
                x++;
            }
            int y=mincoin(arr, k + 1, sum) ;
            if(x==-1 && y==-1){
                return -1;
            }else if(x==-1){
                return y;
            }else if(y==-1){
                return x;
            }else{
                return Math.min(x,y);
            }
        }
    }

    public static int mincoinWithDp(int arr[],int sum) {
        int dp[][]=new int[arr.length][sum];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-2);
        }
        return mincoinWithDp(arr,0,sum,dp);
    }

    public static int mincoinWithDp(int arr[],int k,int sum,int dp[][]){
        if (sum == 0) {
            return 0;
        } else if (sum < 0 || k == arr.length) {
            return -1;
        } else {
            if(dp[k][sum-1]==-2) {
                int x = mincoinWithDp(arr, k, sum - arr[k], dp);
                if (x != -1) {
                    x++;
                }
                int y = mincoinWithDp(arr, k + 1, sum, dp);
                if (x == -1 && y == -1) {
                    dp[k][sum-1]= -1;
                } else if (x == -1) {
                    dp[k][sum-1]= y;
                } else if (y == -1) {
                    dp[k][sum-1]= x;
                } else {
                    dp[k][sum-1]= Math.min(x, y);
                }
            }
            return dp[k][sum-1];
        }
    }

    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        int len,sum;
        for(int l=1;l<=test;l++){
            sum = cin.nextInt();
            len = cin.nextInt();
            int arr[]=new int[len];
            for(int i=0;i<len;i++){
                arr[i]=cin.nextInt();
            }
            System.out.println(mincoinWithDp(arr,sum));
        }
    }
}
