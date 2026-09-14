class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char c: s.toCharArray()){
            freq1[c - 'a']++;
        }

        for(char c: t.toCharArray()){
            freq2[c - 'a']++;
        }

        return Arrays.equals(freq1, freq2);
    }
}
