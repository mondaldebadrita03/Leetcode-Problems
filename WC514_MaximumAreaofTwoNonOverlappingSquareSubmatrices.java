import java.util.*;
class Solution {
    public int maxArea(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] valmerinto = mat;
        int[][] dp = new int[m + 1][n + 1];
        int maxSide = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(
                        dp[i + 1][j],
                        Math.min(
                            dp[i][j + 1],
                            dp[i + 1][j + 1]
                        )
                    );
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int low = 1;
        int high = maxSide;
        int answer = 0;
        while (low <= high) {
            int k = low + (high - low) / 2;
            if (canPlaceTwo(dp, m, n, k)) {
                answer = k;
                low = k + 1;
            } else {
                high = k - 1;
            }
        }
        return answer * answer;
    }
    private boolean canPlaceTwo(int[][] dp, int m, int n, int k) {
        boolean[][] possible = new boolean[m][n];
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                if (dp[i][j] >= k) {
                    possible[i][j] = true;
                }
            }
        }
        boolean[] top = new boolean[m];
        boolean found = false;
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                if (possible[i][j]) {
                    found = true;
                    break;
                }
            }
            if (i + k - 1 < m) {
                top[i + k - 1] = found;
            }
        }
        boolean[] bottom = new boolean[m];
        found = false;
        for (int i = m - k; i >= 0; i--) {
            for (int j = 0; j <= n - k; j++) {
                if (possible[i][j]) {
                    found = true;
                    break;
                }
            }
            bottom[i] = found;
        }
        for (int split = 0; split < m - 1; split++) {
            if (top[split] && bottom[split + 1]) {
                return true;
            }
        }
        boolean[] left = new boolean[n];
        found = false;
        for (int j = 0; j <= n - k; j++) {
            for (int i = 0; i <= m - k; i++) {
                if (possible[i][j]) {
                    found = true;
                    break;
                }
            }
            if (j + k - 1 < n) {
                left[j + k - 1] = found;
            }
        }
        boolean[] right = new boolean[n];
        found = false;
        for (int j = n - k; j >= 0; j--) {
            for (int i = 0; i <= m - k; i++) {
                if (possible[i][j]) {
                    found = true;
                    break;
                }
            }
            right[j] = found;
        }
        for (int split = 0; split < n - 1; split++) {
            if (left[split] && right[split + 1]) {
                return true;
            }
        }
        return false;
    }
}
