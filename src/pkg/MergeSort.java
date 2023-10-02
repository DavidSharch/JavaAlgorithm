package pkg;

import java.util.Arrays;

/**
 * @Author : sharch
 * @create 2023/10/2 19:15
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums1 = new int[]{5, 9, 15, 32, 123, -1, -2, 13};
        int[] sort = sort(nums1);
        System.out.println(Arrays.toString(sort));

//        int[] a = new int[]{5, 9, 15, 32};
//        int[] b = new int[]{1, 2, 6, 8};
//        System.out.println(Arrays.toString(merge(a, b)));
    }

    private static int[] sort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        // 分解
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid); // 左闭右开
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);

        left = sort(left);
        right = sort(right);
        // 合并merge
        return merge(left, right);
    }

    /**
     * merge操作，剩余的数组直接添加到尾部，不需要考虑顺序
     */
    private static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0, j = 0;
        int cnt = 0;
        while (true) {
            if (i == left.length) {
                for (int k = j; k < right.length; k++) {
                    res[cnt] = right[k];
                    cnt++;
                }
                break;
            } else if (j == right.length) {
                for (int k = i; k < left.length; k++) {
                    res[cnt] = left[k];
                    cnt++;
                }
                break;
            }
            if (left[i] > right[j]) {
                res[cnt] = right[j];
                cnt++;
                j++;
            } else {
                res[cnt] = left[i];
                cnt++;
                i++;
            }
        }
        return res;
    }
}
