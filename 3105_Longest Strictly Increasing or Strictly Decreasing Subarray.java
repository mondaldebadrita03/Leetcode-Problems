class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incLen = 1;
        int decLen = 1;
        int ans = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                incLen++;
            }
            else{
                incLen = 1;
            }
            if(nums[i] < nums[i - 1]){
                decLen++;
            }
            else{
                decLen = 1;
            }
            ans = Math.max(ans, Math.max(incLen, decLen));
        }

        return ans;
    }
}
