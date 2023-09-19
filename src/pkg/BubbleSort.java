package pkg;

/**
 * @Author : sharch
 * @create 2023/9/19 20:12
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = bubbleSort(new int[]{1, 2, 3, 2, 1, 6, 7, 2, 0, -1, 12, 1});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    private static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (temp > nums[j]) {
                    int num = temp;
                    temp = nums[j];
                    nums[j] = num;
                }
            }
        }
        return nums;
    }
}
