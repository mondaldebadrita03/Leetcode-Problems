class Solution {
    public int arrangeCoins(int n) {
        long s = 0;
        long e = n;
        while(s <= e){
            long m = s + (e - s) / 2;
            long rem = m * (m + 1) / 2;

            if(rem == n){
                return (int) m;
            }
            else if(rem < n){
                s = m + 1;
            }
            else{
                e = m - 1;
            }
        }
        return (int) e;
    }
}
