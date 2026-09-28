// Approach 1
// Easier to Visualize what's happening through this approach

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maxDepth(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int maxDepth = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
                maxDepth = Math.max(maxDepth, stack.size());
            }
            else if(c == ')'){
                stack.pop();
            }
        }
        return maxDepth;
    }
}


// Approach 2
// Well, Why do we need to use Stack Data structure if the problem can be solved without it?

class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int count = 0;
      
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
                maxDepth = Math.max(maxDepth, count);
            }
            else if(c == ')'){
                count--;
            }
        }
        return maxDepth;
    }
}
