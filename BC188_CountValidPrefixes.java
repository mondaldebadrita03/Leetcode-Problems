class Solution {
    public int countValidPrefixes(String s) {
        int count=0;
        for(int y=0; y<s.length(); y++){
            if(isAlternatingString(s.substring(0, y+1)))
                count++;
        }
        return count;
    }
     private boolean isAlternatingString(String s){
        if(s.length()==1)
            return true;
        if(s.length()==2){
            return s.charAt(0) != s.charAt(1);
        }
        int zeroCount = 0;
        int oneCount = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1')
                oneCount++;
            else
                zeroCount++;
        }
        return Math.abs(zeroCount - oneCount) <= 1;
    }
}
   
