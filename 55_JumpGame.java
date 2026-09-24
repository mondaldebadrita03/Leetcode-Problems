class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        int maxJump = 0;
        int n = nums.length;

        while(i < n && i <= maxJump){
            maxJump = Math.max(maxJump, i + nums[i]);
            
            if(maxJump >= n - 1)
                return true;

            i++;
        }
        return false;
    }
}
