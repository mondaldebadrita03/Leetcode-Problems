class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //Arrays.sort(nums);    // this approach can't be used since we need to follow the original order of the nums array(original), so we're gonna use brute force here

        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int count = 0;

            for(int j = 0; j < nums.length; j++){
                if(nums[j] < nums[i])
                    count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}
