class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }

        int wayOne = 1;
        int wayTwo = 2;

        for(int i = 3; i <= n; i++){
            int curr = wayOne + wayTwo;

            wayOne = wayTwo;
            wayTwo = curr;
        }

        return wayTwo;
    }
}
