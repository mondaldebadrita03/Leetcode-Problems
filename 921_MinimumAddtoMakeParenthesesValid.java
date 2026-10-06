// Using stack

import java.util.Stack;
class Solution {
    public int minAddToMakeValid(String s) {
        int depth = 0;
        int count = 0;
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(c == '('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    count++;
                }
                else{
                    stack.pop();
                }
            } 
        }
        return count + stack.size();
    }
}

// Without stack

class Solution {
    public int minAddToMakeValid(String s) {
        int depth = 0;
        int count = 0;

        for(char c: s.toCharArray()){
            if(c == '('){
                depth++;
            }
            else{
                if(depth == 0){
                    count++;
                }
                else{
                    depth--;
                }
            } 
        }
        return count + depth;
    }
}
