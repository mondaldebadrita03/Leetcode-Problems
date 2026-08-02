class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int count =0;
        for(int i=0; i<nums.length; i++){
            int x=0;
            int y=0;
            for(int j=i; j<nums.length; j++){
                if(nums[j]%2==0)
                    x++;
                else
                    y++;
                if(isValidSubarray(x, y, a, b))
                   count++;
            }
        }
        return count;
    }
    public boolean isValidSubarray(int x, int y, int a, int b ){
        if(y==0){
            return false;
        }
        return (long)x*b<=(long)a*y;
    }
}
