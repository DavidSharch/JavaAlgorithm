package main;

/**
 * @Author : sharch
 * @create 2023/9/17 19:21
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates26 {
    public static void main(String[] args) {
        //removeDuplicates(new int[]{1,1,2});
        //removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});

        removeDuplicatesII(new int[]{1,1,1,2,2,2,3,3,4,4,5,6,7,7,8});
        //removeDuplicatesII(new int[]{1,1,1,2,2,3});
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int res = 1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != nums[i]) {
                i++;
                nums[i] = nums[k];
                res++;
            }
        }
        return res;
    }

    /**
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/
     */
    public static int removeDuplicatesII(int[] nums) {
        // 数组中的一号和二号元素肯定不用删除
        int count = 2;
        for(int i = 2 ; i < nums.length ; i++) {
            if(nums[i] != nums[count-2]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
