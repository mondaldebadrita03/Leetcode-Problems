class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int lCount = 0;
        int rCount = 0;
        int firstHalf = 0;
        int secondHalf = 0;

        for(int i = 0; i < n; i++){
            char c = num.charAt(i);
            if(i < num.length()/2){
                if(c == '?')
                    lCount++;
                else
                    firstHalf += c - '0';
            }
            else{
                if(c == '?')
                    lCount++;
                else
                    secondHalf += c - '0';
            }

        }
        return (firstHalf - secondHalf) != 4.5 * (rCount - lCount);
    }
}
