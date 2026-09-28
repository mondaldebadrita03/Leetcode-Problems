// Approach 1 
// T.C: O(N²) (Quadratic time)
// S.C : O(N)

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


// Approach 2
// T.C: O(N)
// S.C : O(N)

class Solution {
    public String reverseVowels(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder rev = new StringBuilder();
        String vowels = "aeiouAEIOU";

        for (int i = s.length() - 1; i >= 0; i--) {
            if (vowels.contains(String.valueOf(s.charAt(i)))) {
                rev.append(s.charAt(i));
            }
        }

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(String.valueOf(s.charAt(i)))) {
                ans.append(rev.charAt(j));
                j++;
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}


// Approach 3
// T.C: O(N)
// S.C : O(1)

class Solution {
    public String reverseVowels(String s) {
        
        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";

        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }
            
            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }
            
            // Swapping the vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            left++;
            right--;
        }
        
        return new String(chars);
    }
}
