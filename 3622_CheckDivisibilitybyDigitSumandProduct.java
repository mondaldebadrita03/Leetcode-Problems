class Solution {
    public boolean checkDivisibility(int n) {
        int digitSum = 0;
        int product = 1;
        int num = n;

        while(num > 0){
            int digit = num % 10;
            digitSum += digit;
            product *= digit;
            num /= 10;
        }

        if(digitSum + product == 0)
            return false;
        return n % (digitSum + product) == 0;
    }
}
