package pkg;

/**
 * @Author : sharch
 * @create 2023/9/19 20:12
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] ints = insertSort(new int[]{1, 2, 3, 2, 1, 6, 7, 2,0,-1,12,1});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 插入排序
     * 关键点在于，倒序找到自己要插入的地方
     */
    private static int[] insertSort(int[] nums){
        // 认为0位置的是已经排序好的，从1开始
        for (int i = 1; i < nums.length; i++) {
            // 倒序，回头找到自己要插入的位置
            // 这里看成独立的，已经排好序的，一个数组
            for (int j = i; j > 0; j--) {
                // j自己和自己比较
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
            }
        }
        return nums;
    }
}
