class Solution {
    public int mySqrt(int x) {
        if(x < 2)
            return x;

        long i = 1;
        long j = x / 2;
        long sqrt = 0;
        while(i <= j){
            long m = i + (j - i)/2;
            long sq = m * m;

            if(sq == x){
                return (int)m;
            }
            else if(sq < x){
                sqrt = m;
                i = m + 1;
            }
            else{
                j = m - 1;
            }
        }
        return (int)sqrt;
        
    }
}
