package com.chujianyun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Easy {


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
        return null;
    }


}
