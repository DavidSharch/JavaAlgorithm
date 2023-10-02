package main;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : sharch
 * @create 2023/9/30 20:30
 * <p>
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */
public class MidOfTwoSortedNums {
    public static void main(String[] args) {
        int[] nums1 = new int[]{5, 9, 15, 32};
        int[] nums2 = new int[]{1, 2, 6, 8};
        System.out.println(findMedianSortedArrays(nums1, nums2)); // 7

        int[] nums3 = new int[]{5, 9, 15};
        int[] nums4 = new int[]{1, 2, 6, 8};
        System.out.println(findMedianSortedArrays(nums3, nums4)); // 6
    }

    /**
     * 类似归并排序
     * 元素大于一个，就拆分
     */
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0d;
    }
}
