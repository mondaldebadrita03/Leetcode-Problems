// Manual Method

class Solution {
    public String interpret(String command) {
        String ans = "";

        for(int i = 0; i < command.length(); i++){
            if(command.charAt(i) == 'G'){
                ans += "G";
            }
            else if(i + 1 < command.length() && command.charAt(i) == '(' && command.charAt(i + 1) == ')'){
                ans += 'o';
                i++;
            }
            else if(i + 3 < command.length() && command.charAt(i) == '(' && command.charAt(i + 1) == 'a' && command.charAt(i + 2) == 'l' && command.charAt(i + 3) == ')'){
                ans += "al";
                i += 3;
            }
        }
        return ans;
    }
}

// Using Replace Method

class Solution {
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
