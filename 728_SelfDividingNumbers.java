class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();

        for(int i = left; i <= right; i++){
            if(i < 10){
                ans.add(i);
            }
            else{
                if(isSelfDividing(i)){
                    ans.add(i);
                }
            }
        }
        return ans;
    }
    private boolean isSelfDividing(int n){
        int num = n;
        while(num > 0){
            int digit = num % 10;
            if(digit == 0 || n % digit != 0){
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
