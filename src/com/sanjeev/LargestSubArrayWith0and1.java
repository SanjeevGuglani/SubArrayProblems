package com.sanjeev;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sanjeev Guglani
 */
public class LargestSubArrayWith0and1 {
    int maxLen(int[] arr)
    {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
         int cum_sum=0; int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                cum_sum--;
            }else {
                cum_sum++;
            }
            if(cum_sum==0 && max<(i+1)){
                max = i+1;
            }
            if(!map.containsKey(cum_sum)){
                map.put(cum_sum,i);
            }else if(max<(i-map.get(cum_sum))){
                max = i- map.get(cum_sum);
            }
        }
        return max;
    }
}
