class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;

        int power = (int) Math.round(Math.log(n) / Math.log(2.0));
        return Math.pow(2, power) == n;
    }
}
