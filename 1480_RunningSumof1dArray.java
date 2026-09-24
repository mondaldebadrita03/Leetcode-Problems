// Brute force approach : T.C: O(n2)

class Solution {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = 0; j <= i; j++){
                sum += nums[j];
            }
            ans[i] = sum;
        }
        return ans;
    }
}

// Building Block Approach : T.C: O(n)

class Solution {
    public int[] runningSum(int[] nums) {

        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}
