package pkg;

/**
 * @Author : sharch
 * @create 2023/9/19 20:12
 * todo 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] temp = new int[]{1, 2, 3, 2, 1, 6, 7, 2,0,-1,12,1};
        int[] ints = quickSort(temp,0,temp.length-1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    // https://blog.csdn.net/weixin_40017062/article/details/115732885
    private static int[] quickSort(int[] nums, int start, int end) {
        int i = 0, j = nums.length - 1;
        return null;
    }
}
