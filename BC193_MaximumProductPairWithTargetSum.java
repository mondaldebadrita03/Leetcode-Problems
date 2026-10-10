// Approach 1

class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int maxProduct = Integer.MIN_VALUE;
        int[] ans = {-1, -1};
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target && nums[i] != nums[j]){
                    if(maxProduct < nums[i] * nums[j]){
                        maxProduct = nums[i] * nums[j];
                        if(nums[i] < nums[j]){
                            ans[0] = j;
                            ans[1] = i;
                        }
                        else{
                            ans[0] = i;
                            ans[1] = j;
                        }
                    }
                }
            }
        }
        return ans;
    }
}


// Approach 2

class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int maxProduct = Integer.MIN_VALUE;
        int[] ans = {-1, -1};
        
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i != j && nums[i] + nums[j] == target && nums[i] > nums[j]){
                    if(maxProduct < nums[i] * nums[j]){
                        maxProduct = nums[i] * nums[j];
                        ans = {i, j};
                    }
                }
            }
        }
        return ans;
    }
}
