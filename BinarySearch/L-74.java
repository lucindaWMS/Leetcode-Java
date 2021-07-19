//L.74 Search a 2D Matrix
//O(m + logn) time O(1) space
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        int minRow = 0;
        int maxRow = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            if (target > matrix[i][matrix[i].length - 1]) {
                minRow = Math.max(minRow, i + 1);
            } else if (target < matrix[i][0]) {
                maxRow = Math.min(maxRow, i - 1);
            }
        }
        for (int i = minRow; i <= maxRow; i++) {
            if (target > matrix[i][matrix[i].length - 1]) {
                continue;
            } else {
                return binarySearch(matrix, i, target);
            }
        }
        return false;
    }
    
    public boolean binarySearch(int[][] matrix, int row, int target) {
        int left = 0;
        int right = matrix[0].length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else  {
                right = mid - 1;
            }
        }
        if (matrix[row][left] == target) {
            return true;
        }
        if (matrix[row][right] == target) {
            return true;
        }
        return false;
    }
}

//Solution from Leetcode
//O(log(mn)) time O(1) space
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        // binary search
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement)
                return true;
            else {
                if (target < pivotElement)
                    right = pivotIdx - 1;
                else
                    left = pivotIdx + 1;
            }
        }
        return false;
    }
}