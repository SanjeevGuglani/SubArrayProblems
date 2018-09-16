package com.sanjeev;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Sanjeev Guglani
 */
public class SubArraySumToK {

    //Time O(n) //space O(n)
    public static void subArrayToK(int arr[],int s){
        int sum=0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==s){
                System.out.println("1 "+(i+1));
                return;
            }else if(arr[i]==s) {
                System.out.println((i+1)+" "+(i+1));
                return;
            }else if(map.containsKey(sum-s)){
                System.out.println((map.get(sum-s)+2)+" "+(i+1));
                return;
            }else {
                map.put(sum,i);
            }
        }
        System.out.println(-1);
    }

    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        int len,sum;
        for(int l=1;l<=test;l++){
            len = cin.nextInt();
            sum = cin.nextInt();
            int arr[]=new int[len];
            for(int i=0;i<len;i++){
                arr[i]=cin.nextInt();
            }
            subArrayToK(arr,sum);
        }
    }
}
