// Approach 1

class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                left++;
            }
            else{
                right++;
            }

            if(left == right){
                maxLen = Math.max(maxLen, 2 * right);
            }
            else if(right > left){
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);

            if(c == '('){
                left++;
            }
            else{
                right++;
            }

            if(left == right){
                maxLen = Math.max(maxLen, 2 * left);
            }
            else if(left > right){
                left = 0;
                right = 0;
            }
        }

        return maxLen;
    }
}

// Approach 2

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> q = new Stack<>();
        q.push(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                q.push(i);
            } else {
                q.pop();
                
                if (q.isEmpty()) {
                    q.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - q.peek());
                }
            }
        }
        return maxLen;
    }
}
