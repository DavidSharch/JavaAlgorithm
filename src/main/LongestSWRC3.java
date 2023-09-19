package main;

import java.util.*;

/**
 * @Author : sharch
 * @create 2023/9/17 20:22
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class LongestSWRC3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringV3("bcddbbbbbcdeffgg"));
        //System.out.println(lengthOfLongestSubstringV3(" "));
        //System.out.println(lengthOfLongestSubstringV3("au"));
    }

    /**
     * 暴力解法，就是找出全部子串
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = 1;
            StringBuilder tempStr = new StringBuilder();
            tempStr.append(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (tempStr.indexOf(String.valueOf(s.charAt(j))) == -1) {
                    tempStr.append(s.charAt(j));
                    temp++;
                } else {
                    break;
                }
            }
            if (temp > res) {
                res = temp;
            }
        }
        return res;
    }

    /**
     * 使用map记录一个字符是否存在，依然是O(N^2)
     */
    public static int lengthOfLongestSubstringII(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int res = 0;
        // bcddbbbbbcdeffgg
        for (int i = 0; i < s.length(); i++) {
            int temp = 1;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    temp++;
                } else {
                    break;
                }
            }
            if (temp > res) {
                res = temp;
            }
        }
        return res;
    }

    /**
     * 滑动窗口
     *
     */
    public static int lengthOfLongestSubstringV3(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        // bcddbbbbbcdeffgg
        for (int i = 0; i < s.length(); i++) {
            // 当前char已经存在
            if (map.containsKey(s.charAt(i))) {
                // left左移
                // map.get(s.charAt(i)) + 1，为了处理出现一样字符的情况
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 更新char和位置关系
            map.put(s.charAt(i), i);
            // 更新max结果
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
