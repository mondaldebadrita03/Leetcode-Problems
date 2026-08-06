class Solution {
    Integer[] dp;
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new Integer[n];
        int gap = getScoreGap(stoneValue, 0);
        if (gap > 0)
            return "Alice";
        else if (gap < 0)
            return "Bob";
        else
            return "Tie";
    }
    private int getScoreGap(int[] arr, int i) {
        if (i >= arr.length)
            return 0;
        if (dp[i] != null)
            return dp[i];
        int best = Integer.MIN_VALUE;
        int sum = 0;
        // Pick 1, 2 or 3 stones
        for (int k = 0; k < 3 && i + k < arr.length; k++) {
            sum += arr[i + k];
            best = Math.max(best, sum - getScoreGap(arr, i + k + 1));
        }
        return dp[i] = best;
    }
}
