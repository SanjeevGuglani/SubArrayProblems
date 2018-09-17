package com.sanjeev;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Sanjeev Guglani
 */
public class SubSetSumToK {

    public static int subsetSumToK(int arr[],int sum){
        return subsetSumToK(arr,0,sum);
    }

    public static int subsetSumToK(int arr[],int k,int sum){
        if(sum==0){
            return 1;
        }else if(sum<0 || k==arr.length){
            return 0;
        }else{
            return subsetSumToK(arr,k+1,sum-arr[k])+
                    subsetSumToK(arr,k+1,sum);
        }
    }


    public static int subsetSumToKWithDP(int arr[],int sum){
        int dp[][]=new int[arr.length][sum];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return subsetSumToKWithDP(arr,0,sum,dp);
    }


    public static int subsetSumToKWithDP(int arr[],int k,int sum,int dp[][]){
        if(sum==0){
            return 1;
        }else if(sum<0 || k==arr.length){
            return 0;
        }else{
            if(dp[k][sum-1]==-1) {
                dp[k][sum-1] =  subsetSumToKWithDP(arr, k + 1, sum - arr[k],dp) + subsetSumToKWithDP(arr, k + 1, sum,dp);
            }
            return dp[k][sum-1];
        }
    }


    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        int len,sum;
        for(int l=1;l<=test;l++){
            len = cin.nextInt();
            int arr[]=new int[len];
            for(int i=0;i<len;i++){
                arr[i]=cin.nextInt();
            }
            sum = cin.nextInt();
            System.out.println(subsetSumToKWithDP(arr,sum));
        }
    }
}
