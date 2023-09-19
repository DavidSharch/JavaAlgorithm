package main;

/**
 * https://leetcode.cn/problems/reverse-integer/
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseV3(200100));
    }
    /**
     * 数学法
     */
    private static int reverse(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }
        int sign = x < 0 ? -1 : 1;
        x = x < 0 ? -x : x;

        long res = 0;
        while (x / 10 > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        // 最后还有一个数字
        res = res * 10 + x;
        if (res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res * sign;
    }

    /**
     * 逆序遍历
     *
     * @param x
     * @return
     */
    private static int reverseV2(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }
        // 记录正负号，返回结果时直接 * sign
        int sign = x < 0 ? -1 : 1;
        // x全部当成正数使用
        x = x < 0 ? -x : x;

        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        char[] reverseChars = new char[chars.length];
        int j = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            // 倒序遍历
            reverseChars[j] = chars[i];
            j++;
        }

        long tempRes = Long.parseLong(String.valueOf(reverseChars));
        if (tempRes >= Integer.MAX_VALUE) {
            return 0;
        }
        return (int) tempRes * sign;
    }

    /**
     * 首尾交换
     */
    private static int reverseV3(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}

