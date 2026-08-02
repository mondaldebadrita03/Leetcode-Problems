class Solution {
    public long maxPairStrength(int[] nums) {
        long strength = 0;
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                long cd = gcd(nums[i], nums[j]);
                long currentStrength = ((long) nums[i] * nums[j]) / (cd * cd);
                strength = strength > currentStrength ? strength : currentStrength;
            }
        }
        return strength; 
    }
    public int gcd(int x, int y){
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return Math.abs(x);
    }
}
