class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // flatten it is a long list
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int col = mid % matrix[0].length;
            int row = mid / matrix[0].length;
            int val = matrix[row][col];
            if (val == target) return true;
            if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
