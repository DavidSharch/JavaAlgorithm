package main;

import java.util.Stack;

/**
 * @Author : sharch
 * @create 2023/9/14 20:16
 * https://leetcode.cn/problems/remove-outermost-parentheses/
 */
public class RemoveOutPare {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses("()()"));
    }

    /**
     * 遇到)就弹出，如果stack为空，就说明是一个原语
     * @param s
     * @return
     */
    public static String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            temp.append(c);
            if ('(' == c) {
                stack.push("(");
            } else {
                // 遇到)，就弹出一个
                String pop = stack.pop();
                if (stack.size() == 0) {
                    res.append(temp.substring(1, temp.length() - 1));
                    temp = new StringBuilder();
                }
            }
        }
        return res.toString();
    }
}
