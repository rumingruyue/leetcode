package com.chujianyun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Easy {


    /**
     * 判断一个整数是否为回文字(字符串方法)
     *
     * @param x 输入的整数
     * @return 结果
     */
    public boolean isPalindrome1(int x) {

        if (x < 0) {
            return false;
        }
        String strX = String.valueOf(x);
        int length = strX.length();
        int left = length / 2 - 1;
        int right = length % 2 == 0 ? left+1 : left + 2;
        while (left >= 0) {
            if (strX.charAt(left) != strX.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
    /**
     * 判断一个整数是否为回文字（反转数字）
     *
     * @param x 输入的整数
     * @return 结果
     */
    public boolean isPalindrome(int x) {
        int y = x;
        if (x < 0) {
            return false;
        }

        int result = 0;
        while(x !=0){

            if (result*10 + x%10>Integer.MAX_VALUE){
                return false;
            }
            result = result*10 + x%10;
            x = x/10;
        }
        return result == y;
    }


    /**
     * 判断一个整数是否为回文字
     *
     * @param x 输入的整数
     * @return 结果
     */
    public boolean isPalindrome2(int x) {

        if (x < 0) {
            return false;
        }

        long result = 0L;
        while(x !=0){
            result = result*10 + x%10;
             if (result>Integer.MAX_VALUE){
                 return false;
             }
             x = x/10;
        }

        return Long.compare(result,(long)x) ==0;
    }

    /**
     * 反转整数
     *
     * @param x 整数
     * @return 反转
     */
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }


    /**
     * 整形数组，找出和为某数的两个数字
     *
     * @param nums   整型数组
     * @param target 目标数字
     * @return 满足和为target的两个整数
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> tmpMap = new HashMap<>(nums.length);
        //遍历并记录到Map中
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (tmpMap.containsKey(complement) && tmpMap.get(complement) != i) {
                return new int[]{i, tmpMap.get(complement)};
            }
            tmpMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 整形数组，找出和为某数的两个数字
     *
     * @param nums   整型数组
     * @param target 目标数字
     * @return 满足和为target的两个整数
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tmpMap = new HashMap<>(nums.length);
        //遍历并记录到Map中
        for (int i = 0; i < nums.length; i++) {
            tmpMap.put(nums[i], i);
        }
        //遍历一次直接匹配
        for (int i = 0; i < nums.length; i++) {
            if (tmpMap.containsKey(target - nums[i]) && tmpMap.get(target - nums[i]) != i) {
                return new int[]{i, tmpMap.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
