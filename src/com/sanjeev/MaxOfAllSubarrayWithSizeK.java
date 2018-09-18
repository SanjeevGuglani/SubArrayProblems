package com.sanjeev;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Sanjeev Guglani
 */
public class MaxOfAllSubarrayWithSizeK {

    //O(n) //O(k)
    //check time complexity by taking example
    //Max it is removing and adding 1 element in quest so total operation 2
    //O(2n)=O(n)
    public static void subArray(int arr[],int k){
        int i;
        Deque<Integer> deque = new LinkedList<Integer>();
        for(i=0;i<k;i++){
           if(!deque.isEmpty() && deque.peek()<arr[i]){
               deque.clear();
           }else{
               while(!deque.isEmpty() && deque.peekLast()<arr[i]){
                   deque.pollLast();
               }
           }
            deque.addLast(arr[i]);
        }
        System.out.print(deque.peekFirst());
        for(;i<arr.length;i++){
            if(!deque.isEmpty() && deque.peek()==arr[i-k]){
                deque.pollFirst();
            }
            if(!deque.isEmpty() && deque.peek()<arr[i]){
                deque.clear();
            }else{
                while(!deque.isEmpty() && deque.peekLast()<arr[i]){
                    deque.pollLast();
                }
            }
            deque.addLast(arr[i]);
            System.out.print(" "+deque.peekFirst());
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        int len,k;
        for (int l = 1; l <= test; l++) {
            len = cin.nextInt();
            k = cin.nextInt();
            int arr[] = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = cin.nextInt();
            }
            subArray(arr, k);
            System.out.println();
        }
    }
}
