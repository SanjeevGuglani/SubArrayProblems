package com.sanjeev;

import java.util.*;

/**
 * Created by Sanjeev Guglani
 */
public class LargestSubArraySumTo0 {


    //Time O(n) //space O(n)
    public static int largestSubArrayTo02(int arr[]){
        int sum=0,max=0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0 && (i+1)>max){
                max = i+1;
            }else if(arr[i]==0 && max<1) {
                max =1;
            }else if(map.containsKey(sum) && max<(i-map.get(sum))){
                max = i-map.get(sum);
            }else {
                map.put(sum,i);
            }
        }
        return max;
    }

    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        int len;
        for(int l=1;l<=test;l++){
            len = cin.nextInt();
            int arr[]=new int[len];
            for(int i=0;i<len;i++){
                arr[i]=cin.nextInt();
            }
            System.out.println(largestSubArrayTo02(arr));
        }
    }
}
