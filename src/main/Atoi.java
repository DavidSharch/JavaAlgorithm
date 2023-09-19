package main;

/**
 * @Author : sharch
 * @create 2023/9/13 10:32
 * https://leetcode.cn/problems/string-to-integer-atoi/
 */
public class Atoi {
    public static void main(String[] args) {
//        System.out.println(myAtoi("   -42"));
//        System.out.println(myAtoi("4193 with words"));
//        System.out.println(myAtoi("41"));
//        System.out.println(myAtoi("words and 987"));
//        System.out.println(myAtoi(""));
//        System.out.println(myAtoi("-91283472332"));
//        System.out.println(myAtoi("91283472332"));
//        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoi("  0000000000012345678"));
    }

    public static int myAtoi(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        s = s.trim();
        int sign = 1;
        if (s.startsWith("-")) {
            sign = -1;
            s = s.substring(1);
        } else if (s.startsWith("+")) {
            sign = 1;
            s = s.substring(1);
        }
        boolean start = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            if (start && c == '0') {
                continue;
            }else{
                start = false;
            }
            sb.append(c);
        }
        if (sb.length() > 0) {
            if (sb.length() > "91283472332".length()) {
                if (sign > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            long res = Long.parseLong(sb.toString()) * sign;
            if (res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (res >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) res;
        }
        return 0;
    }
}
