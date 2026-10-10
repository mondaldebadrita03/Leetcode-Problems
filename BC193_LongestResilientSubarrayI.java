class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int maxLen = 1;
        
        for(int i = 0; i < nums.length; i++){
            int r = nums[i] % k;
            long sum = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] % k != r)
                    break;
                sum += nums[j];
                if(sum % k == r)
                    maxLen = Math.max(maxLen, j - i + 1); 
            }
        }
        return maxLen;
    }
}
