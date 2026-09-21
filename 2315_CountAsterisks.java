class Solution {
    public int countAsterisks(String s) {
        int count = 0;
        int pairs = 0;

        for(char c: s.toCharArray()){
            if(c == '|')
                pairs++;
            if(c == '*' && pairs % 2 == 0)
                count++;
        }
        return count;
    }
}
