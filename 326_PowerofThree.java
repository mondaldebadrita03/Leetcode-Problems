// Without loops (using log)
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)
            return false;
        double logResult = Math.log10(n) / Math.log10(3);
        long roundedLog = Math.round(logResult);
        
        return Math.pow(3, roundedLog) == n;
    }
}

// Maximum-Value Trick
class Solution {
    public boolean isPowerOfThree(int n) {
        
        return n > 0 && 1162261467 % n == 0;
    }
}
