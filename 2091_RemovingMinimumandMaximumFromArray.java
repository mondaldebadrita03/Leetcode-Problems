class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int min_index = 0;
        int max_index = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] < min){
                min = nums[i];
                min_index = i;
            }
            if(nums[i] > max){
                max = nums[i];
                max_index = i;
            } 
        }
        int left = Math.max(min_index, max_index) + 1;
        int right = n - Math.min(min_index, max_index);
        int both = Math.min(min_index, max_index) + 1 + n - Math.max(min_index, max_index);

        return Math.min(left, Math.min(right, both));
    }
}
