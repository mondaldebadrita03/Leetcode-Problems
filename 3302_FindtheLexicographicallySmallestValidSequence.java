class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] suf = new int[n + 1];
        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1];
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suf[i]++;
                j--;
            }
        }
        int[] ans = new int[m];
        int i = 0;
        j = 0;
        while (i < n && j < m) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            }
            else {
                int remaining = m - j - 1;
                if (suf[i + 1] >= remaining) {
                    ans[j] = i;
                    j++;
                    i++;
                    break;
                }
            }
            i++;
        }
        while (i < n && j < m) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            }
            i++;
        }
        if (j == m) {
            return ans;
        }
        return new int[0];
    }
}
