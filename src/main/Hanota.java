package main;

import java.util.List;

/**
 * @Author : sharch
 * @create 2023/9/19 15:29
 * https://leetcode.cn/problems/hanota-lcci/
 */
public class Hanota {
    /**
     * 递归
     * 假设一共n层，把n-1当成一个整体，移动到B上。最下面的n移动到C，再把B上的n-1移动到C上
     * 问题变成如何处理移动n-1的问题（递归）
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        moveHanota(A.size(),A,B,C);
    }

    /**
     * @param size 移动几个盘子
     * @param a 开始柱子
     * @param b 中间柱子
     * @param c 目标柱子
     */
    private void moveHanota(int size, List<Integer> a, List<Integer> b, List<Integer> c) {
        if (size == 1) {
            // 把a的最后一个盘子移动到c上
            c.add(a.remove(a.size() - 1));
            return;
        }
        // 移动n-1到b
        moveHanota(size - 1, a, c, b);
        // 移动n到c
        moveHanota(1, a, b, c);
        // 移动b上的n-1到c
        moveHanota(size - 1, b, a, c);
    }

    public int recursion(int n) {
        if (n == 1) {
            return 1;
        }
        // do sth
        System.out.println(n);
        return n + recursion(n - 1);
    }
}
