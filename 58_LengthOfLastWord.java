class Solution {
    public int lengthOfLastWord(String s) {
        String str = s.trim(); 
        int n=str.length()-1;
        int len=0;
        for(int i=n; i>=0; i--){
            char c=str.charAt(i);
            if(Character.isWhitespace(c))
                break;
            len++;
        }
        return len;
    }
}
