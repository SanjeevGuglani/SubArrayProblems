package com.sanjeev;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Sanjeev Guglani
 */
public class CoinChange {

    public static int ways(int arr[], int sum) {
        return ways(arr, 0, sum);
    }

    public static int ways(int arr[], int k, int sum) {
        if (sum == 0) {
            return 1;
        } else if (sum < 0 || k == arr.length) {
            return 0;
        } else {
            return ways(arr, k, sum - arr[k]) + ways(arr, k + 1, sum) ;
        }
    }

    public static int waysWithDP(int arr[], int sum) {
        int dp[][]=new int[arr.length][sum];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return waysWithDP(arr, 0, sum,dp);
    }

    public static int waysWithDP(int arr[], int k, int sum,int dp[][]) {
        if (sum == 0) {
            return 1;
        } else if (sum < 0 || k == arr.length) {
            return 0;
        } else {
            if(dp[k][sum-1]==-1) {
             dp[k][sum-1] = waysWithDP(arr, k, sum - arr[k],dp) + waysWithDP(arr, k + 1, sum,dp);
            }
            return dp[k][sum-1];
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        int len, sum;
        for (int l = 1; l <= test; l++) {
            len = cin.nextInt();
            int arr[] = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = cin.nextInt();
            }
            sum = cin.nextInt();
            System.out.println(waysWithDP(arr, sum));
        }
    }
}
