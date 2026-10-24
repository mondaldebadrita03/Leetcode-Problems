class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long subLen = 0;
        long ans = 0;
        
        for(int num: nums){
            if(num >= minK && num <= maxK){
                subLen++;
                ans += subLen;
            }
            else{
                subLen = 0;
            }
        }
        return ans;
    }
}
