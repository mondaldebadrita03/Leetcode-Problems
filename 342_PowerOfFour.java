class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0)
            return false;
            
        int power = (int)(Math.log(n) / Math.log(4.0));
        return Math.pow(4, power) == n;
    }
}
