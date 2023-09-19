package main;

/**
 * @Author : sharch
 * @create 2023/9/17 20:02
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 */
public class ReverseWords151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("    a   123  "));

    }
    public static String reverseWords(String s) {
        s = s.trim();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) != ' ') {
                        i = j - 1;
                        break;
                    }
                }
            }
            str.append(s.charAt(i));
        }
        String[] s1 = str.toString().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (res.length() > 0) {
                res.append(" ");
            }
            res.append(s1[i]);
        }
        return res.toString();
    }
}
