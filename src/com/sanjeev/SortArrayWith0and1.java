package com.sanjeev;

import java.util.Scanner;

/**
 * Created by Sanjeev Guglani
 */
public class SortArrayWith0and1 {

    //O(n) with two loops
    public static void sortBinaryArray1(int arr[]){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)
                count++;
        }
        for(int i=0;i<arr.length;i++,count--){
            arr[i]=(count>0)?0:1;
        }
    }

    //O(n) with one loops
    public static void sortBinaryArray2(int arr[]){
        for(int i=0,j=arr.length-1;i<j;i++,j--){
            while (i<arr.length && arr[i]!=1){
                i++;
            }
            while (j>=0 && arr[j]!=0){
                j--;
            }
            if(i<j){
                arr[j]=1;
                arr[i]=0;
            }
        }
    }

    public static void printSortedArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
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
            sortBinaryArray2(arr);
            printSortedArray(arr);
            System.out.println();
        }

    }
}
