class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;

        int oriNum = x;
        int revNum = 0;

        while(x!=0){
            int lastDig = x % 10;
            revNum = revNum * 10 + lastDig;
            x = x / 10;
        }
        return oriNum == revNum;
    }
}
