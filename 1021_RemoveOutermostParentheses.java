class Solution {
    public String removeOuterParentheses(String s) {
        int depth = 0;
        StringBuilder ans = new StringBuilder();
        int i = 0;

        while(i < s.length()){
            if(s.charAt(i) == '('){
                depth++;
                if(depth > 1){
                    ans.append('(');
                }
            }
            else{
                if(depth > 1){
                    ans.append(')');
                }
                depth--;
            }
            i++;
        }
        
        return ans.toString();
    }
}
