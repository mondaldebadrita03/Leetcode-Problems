class Solution {
    public int minRotations(int n, String s) {
        int total = dist(0, s.charAt(0) - '0');

        for (int i = 1; i < n; i++) {
            int prev = s.charAt(i - 1) - '0';
            int curr = s.charAt(i) - '0';

            total += dist(prev, curr);
        }

        int ans = total;
        int first = s.charAt(0) - '0';
        int last = s.charAt(n - 1) - '0';
        int cost = total - dist(0, first) + dist(0, last);
        ans = Math.min(ans, cost);

        for (int k = 1; k < n; k++) {

            int prev = s.charAt(k - 1) - '0';
            int curr = s.charAt(k) - '0';
            int newCost = total - dist(prev, curr) + dist(prev, last);
            ans = Math.min(ans, newCost);
        }

        return ans;
    }

    private int dist(int a, int b){
        int d = Math.abs(a - b);
        return Math.min(d, 10 - d);
    }
}

