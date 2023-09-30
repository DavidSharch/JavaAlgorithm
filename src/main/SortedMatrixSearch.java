package main;

/**
 * @Author : sharch
 * @create 2023/9/26 20:25
 */
public class SortedMatrixSearch {
    public static void main(String[] args) {
        int[][] nums = new int[5][5];
        nums[0] = new int[]{1, 4, 7, 11, 15};
        nums[1] = new int[]{2, 5, 8, 12, 19};
        nums[2] = new int[]{3, 6, 9, 16, 22};
        nums[3] = new int[]{10, 13, 14, 17, 24};
        nums[4] = new int[]{18, 21, 23, 26, 30};
        System.out.println(searchMatrixV2(nums, 5));
        System.out.println(searchMatrixV2(nums, 50));
        System.out.println(searchMatrixV2(nums, 1));
        System.out.println(searchMatrixV2(nums, 30));
    }

    /**
     * 暴力解法
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }
        if (target == matrix[0][0] || target == matrix[matrix.length - 1][matrix[0].length - 1]) {
            return true;
        }
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            int start = matrix[i][0];
            int end = matrix[i][matrix[0].length - 1];
            if (start == target || end == target) {
                return true;
            }
            if (target > start && target < end) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (target == matrix[i][j]) {
                        return true;
                    }
                    if (matrix[i][j] > target) {
                        break;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 确定一个数字比target大，则右下1/4排除（数字所在行列划十字）
     * 确定一个数字比target小，则左上1/4排除
     */
    public static boolean searchMatrixV2(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }
        if (target == matrix[0][0] || target == matrix[matrix.length - 1][matrix[0].length - 1]) {
            return true;
        }
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        // 使用对角线对比
        return searchSubMatrix(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private static boolean searchSubMatrix(int[][] matrix, int target,
                                           int startRow, int startColumn,
                                           int endRow, int endColumn
    ) {
        if (startRow > endRow || startColumn > endColumn) {
            return false;
        }
        // 比最小值小，最大值大
        if (matrix[startRow][startColumn] > target || matrix[endRow][endColumn] < target) {
            return false;
        }
        int cnt = Math.min(endRow - startRow + 1, endColumn - startColumn + 1);
        for (int i = 0; i < cnt; i++) {
            if (matrix[startRow + i][startColumn + i] == target) {
                return true;
            }
            // 对角线最后一个元素 || 对角线下一个大于target，开始划分区域
            if (i == cnt - 1 || matrix[startRow + i + 1][startColumn + i + 1] > target) {
                // ↗，↙
                boolean res1 = searchSubMatrix(matrix, target, startRow, startColumn + i + 1, startRow + i, endColumn);
                boolean res2 = searchSubMatrix(matrix, target, startRow + i + 1, startColumn, startRow, endColumn + i);
                return res1 || res2;
            }
        }
        return false;
    }
}
