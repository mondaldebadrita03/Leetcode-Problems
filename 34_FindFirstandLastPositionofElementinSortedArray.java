class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int s = search(nums, target, true);
        int e = search(nums, target, false);
        ans[0] = s;
        ans[1] = e;
        return ans;
    }
    private int search(int[] nums, int target, boolean findFirstOccurrence){
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target < nums[mid]){
                right = mid - 1;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else{
                ans = mid;
                if(findFirstOccurrence){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
        }
        return ans;
    }
}
