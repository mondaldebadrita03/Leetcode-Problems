class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate("", n, 0, ans);
        return ans;
    }

    private void generate(String curr, int n, int len, List<String> ans){
        if(len == 2 * n){
            if(isValid(curr)){
                ans.add(curr);
            }
            return;
        }
        curr += '(';
        generate(curr, n, len + 1, ans);
        curr = curr.substring(0, curr.length() - 1);

        curr += ')';
        generate(curr, n, len + 1, ans);
    }

    private boolean isValid(String s){
        // Stack<Character> stack = new Stack<>();
        int count = 0;

        for(char c: s.toCharArray()){
            if(c == '('){
                // stack.push(c);
                count++;
            }
            else{
                // if(stack.peek() == '(')
                //     stack.pop();
                count--;
            }
            if(count == -1){
                return false;
            }
        }
        return count == 0;
    }
}
