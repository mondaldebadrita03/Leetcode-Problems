class Solution {
    public String longestNiceSubstring(String s) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();

            for (int j = i; j < s.length(); j++) {
                set.add(s.charAt(j));
                boolean nice = true;

                for (char ch : set) {
                    if (Character.isLowerCase(ch)) {
                        if (!set.contains(Character.toUpperCase(ch))) {
                            nice = false;
                            break;
                        }
                    } else {
                        if (!set.contains(Character.toLowerCase(ch))) {
                            nice = false;
                            break;
                        }
                    }
                }

                if (nice && j - i + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }

        return ans;
    }
}
