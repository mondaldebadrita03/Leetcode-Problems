class Solution {
    public String reverseVowels(String s) {

        String ans = "";
        String rev = "";
        String vowels = "aeiouAEIOU";

        for(int i = s.length() - 1; i >= 0; i--){
            if(vowels.contains(String.valueOf(s.charAt(i))))
                rev += s.charAt(i);
        }
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            if(vowels.contains(String.valueOf(s.charAt(i)))){
                ans += rev.charAt(j);
                j++;
            }
            else{
                ans += s.charAt(i);
            }
        }
        return ans;
    }
}
