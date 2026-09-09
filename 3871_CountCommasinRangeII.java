class Solution {
    public long countCommas(long n) {
        long count = 0;
        long mul = 1000L;
        
        while(n >= mul){
            count += n - mul + 1;
            if (mul > Long.MAX_VALUE / 1000) {
                break;
            }
            mul *= 1000L;
        }
        return count;
    }
}
