class Solution {
    public int lengthOfLongestSubstring(String s) {
        int j = 0;
        int count = 0;
        HashSet <Character> set = new HashSet<>();
        for(int i = 0; i < s.length() ; i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            count = Math.max(count , i - j + 1);
        }
        return count;
    }
}
