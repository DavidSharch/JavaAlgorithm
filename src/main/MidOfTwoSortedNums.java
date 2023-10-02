package main;

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
        int i = 0, j = 0;
        int mid1 = 0, mid2 = 0; // 两个中位数
        int len1 = nums1.length;
        int len2 = nums2.length;

        for (int k = 0; k <= (len1 + len2) / 2; k++) {
            // mid1和mid2一直往后移动
            mid1 = mid2;
            // nums1还有数字，同时，num2没有数字或者nums2的更大。就要nums1
            if (i < len1 && (j >= len2 || nums1[i] < nums2[j])) {
                mid2 = nums1[i++];
            } else {
                mid2 = nums2[j++];
            }
        }
        if ((len1 + len2) % 2 == 0) {
            return (mid1 + mid2) / 2.0;
        } else {
            return mid2;
        }
    }
}
