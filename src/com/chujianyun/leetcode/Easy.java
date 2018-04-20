package com.chujianyun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Easy {

    /**
     * 最长公共前缀 (水平扫描)
     * https://leetcode.com/problems/longest-common-prefix/description/
     * @param strs 原始字符串数组
     * @return 最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){ return "";}
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
        {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) { return "";}
            }
        }
        return prefix;
    }


    /**
     * 最长公共前缀(垂直扫描)
     * @param strs 原始字符串数组
     * @return 最长公共前缀
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0){ return "";}
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
    /**
     * 最长公共前缀(分治法)
     * @param strs 原始字符串数组
     * @return 最长公共前缀
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {return "";}
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
            {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
    /**
     * 罗马数字转数字
     *
     * @param s 罗马数字字符串
     * @return 数字
     */
    public static int romanToInt(String s) {
        //存放每个罗马字母对应的数值
        int[] numbers = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    numbers[i] = 1000;
                    break;
                case 'D':
                    numbers[i] = 500;
                    break;
                case 'C':
                    numbers[i] = 100;
                    break;
                case 'L':
                    numbers[i] = 50;
                    break;
                case 'X':
                    numbers[i] = 10;
                    break;
                case 'V':
                    numbers[i] = 5;
                    break;
                case 'I':
                    numbers[i] = 1;
                    break;
                default:
            }
        }

        int sum = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < numbers[i + 1]) {
                sum -= numbers[i];
            } else {
                sum += numbers[i];
            }
        }

        return sum + numbers[numbers.length - 1];
    }

    /**
     * 判断一个整数是否为回文字(字符串方法)
     *
     * @param x 输入的整数
     * @return 结果
     */
    public static boolean isPalindrome1(int x) {

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
    public static boolean isPalindrome(int x) {
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
    public static boolean isPalindrome2(int x) {

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
    public static int reverse(int x) {
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
    public static int[] twoSum2(int[] nums, int target) {
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
    public static int[] twoSum(int[] nums, int target) {
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
