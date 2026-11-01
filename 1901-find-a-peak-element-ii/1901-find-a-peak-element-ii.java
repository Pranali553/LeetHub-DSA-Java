
class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Find maximum element in middle column
            int maxRow = 0;

            for (int i = 1; i < m; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            int current = mat[maxRow][mid];

            int left = (mid == 0) ? -1 : mat[maxRow][mid - 1];
            int right = (mid == n - 1) ? -1 : mat[maxRow][mid + 1];

            // Peak found
            if (current > left && current > right) {
                return new int[]{maxRow, mid};
            }

            // Move left
            if (left > current) {
                high = mid - 1;
            }
            // Move right
            else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    
    }
}