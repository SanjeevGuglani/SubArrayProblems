package com.sanjeev;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Sanjeev Guglani
 */
public class SubArraySumTo0 {

      //Time O(n2) //space O(1)
      //Time O(n2) //space O(1)
      public static boolean subArrayTo0(int arr[]){
          int sum=0,temp;
          for(int i=0;i<arr.length;i++){
              sum+=arr[i];
              if(sum==0){
                  return true;
              }
              temp=sum;
              for(int j=i+1;j<arr.length;j++){
                  temp-=arr[j-(i+1)];
                  temp+=arr[j];
                  if(temp==0){
                      return true;
                  }
              }
          }
          return false;
      }


    //Time O(n) //space O(n)
    public static boolean subArrayTo02(int arr[]){
        int sum=0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0 || arr[i]==0 || set.contains(sum)) {
                return true;
            }else {
                set.add(sum);
            }
        }
        return false;
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
            if(subArrayTo0(arr))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
