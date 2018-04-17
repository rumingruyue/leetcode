package com.chujianyun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Easy {

    /**
     * 反转整数
     * @param x 整数
     * @return 反转
     */
    public int reverse(int x) {
        int result =0;
        while (x != 0)
        {
            int tail = x%10;
            int newResult = result*10+tail;
            if((newResult - tail)/10 != result) {return 0;}
            result = newResult;
            x = x/10;
        }
        return result;
    }



    /**
     * 整形数组，找出和为某数的两个数字
     * @param nums  整型数组
     * @param target 目标数字
     * @return 满足和为target的两个整数
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> tmpMap = new HashMap<>(nums.length);
        //遍历并记录到Map中
        for (int i = 0; i < nums.length; i++) {
           int complement = target - nums[i];
            if (tmpMap.containsKey(complement)&&tmpMap.get(complement)!=i){
                return new int[]{i,tmpMap.get(complement)};
            }
            tmpMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    /**
     * 整形数组，找出和为某数的两个数字
     * @param nums  整型数组
     * @param target 目标数字
     * @return 满足和为target的两个整数
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> tmpMap = new HashMap<>(nums.length);
        //遍历并记录到Map中
        for (int i = 0; i < nums.length; i++) {
            tmpMap.put(nums[i],i);
        }
        //遍历一次直接匹配
        for (int i = 0; i < nums.length; i++) {
            if (tmpMap.containsKey(target - nums[i])&&tmpMap.get(target - nums[i])!=i){
                return new int[]{i,tmpMap.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }




}
