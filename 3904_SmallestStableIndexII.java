class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] index = new int[n];
        int minimum = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            minimum = Math.min(minimum, nums[i]);
            index[i] = minimum;
        }

        int maximum = 0;
        for (int i = 0; i < n; i++) {
            maximum = Math.max(maximum, nums[i]);

            if (maximum - index[i] <= k)
                return i;
        }
        return -1;
    }
}
