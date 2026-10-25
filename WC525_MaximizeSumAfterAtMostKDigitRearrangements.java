class Solution {
    public long maximizeSum(int[] nums, int k) {
        int n = nums.length;
        long[] gains = new long[n];
        long sum = 0;
        
        for(int i = 0; i < n; i++){
            sum += nums[i];
            gains[i] = rearrangeDig(nums[i]) - nums[i];
        }
        
        Arrays.sort(gains);
        
        for(int i = n - 1; i >= n - k && i >= 0; i--){
            if(gains[i] > 0)
                sum += gains[i];
            else
                break;
        }
        return sum;
    }

    private long rearrangeDig(int x){
        char[] dig = String.valueOf(x).toCharArray();
        Arrays.sort(dig);

        StringBuilder rev = new StringBuilder();
        for(int i = dig.length - 1; i >= 0; i--){
            rev.append(dig[i]);
        }
        return Long.parseLong(rev.toString());
    }
}
