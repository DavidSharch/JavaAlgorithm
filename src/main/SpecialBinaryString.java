package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author : sharch
 * @create 2023/9/19 20:22
 * https://leetcode.cn/problems/special-binary-string/
 */
public class SpecialBinaryString {
    public static void main(String[] args) {
        System.out.println(makeLargestSpecial("11011000"));
    }

    public static String makeLargestSpecial(String s) {
        if (s.length() <= 2) {
            return s;
        }
        int cnt = 0, left = 0;
        List<String> subs = new ArrayList<>();
        // 11011000
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    // 0和1的数量相等，记录一个子串
                    subs.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }

        // 排序
        Collections.sort(subs, (a, b) -> b.compareTo(a));
        StringBuilder ans = new StringBuilder();
        for (String sub : subs) {
            ans.append(sub);
        }
        return ans.toString();
    }
}
