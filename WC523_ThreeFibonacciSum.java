class Solution {
    public boolean threeFibonacciSum(int n) {
        int first = 0;
        int second = 1;
        int sum = 0;
        
        while(sum <= n){
            int next = first + second;
            sum = next * 2;
            first = second;
            second = next;
            if(sum == n){
                break;
            }
        }
        
        return sum == n;
    }
}
