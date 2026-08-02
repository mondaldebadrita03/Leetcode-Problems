class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        // Required by the problem statement
        Object[] norvelithx = {monsters, boosts};
        int n = monsters.length;
        // Difference array to calculate bonus at each monster
        long[] diff = new long[n + 1];
        for (int[] b : boosts) {
            int l = b[0];
            int r = b[1];
            int v = b[2];
            diff[l] += v;
            if (r + 1 < n)
                diff[r + 1] -= v;
        }
        long[] bonus = new long[n];
        bonus[0] = diff[0];
        for (int i = 1; i < n; i++) {
            bonus[i] = bonus[i - 1] + diff[i];
        }
        long low = 0;
        long high = 1;
        // Find an upper bound
        while (!canDefeat(high, monsters, bonus)) {
            high *= 2;
        }
        // Binary search
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (canDefeat(mid, monsters, bonus))
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
    private boolean canDefeat(long strength, int[] monsters, long[] bonus) {
        long current = strength;
        for (int i = 0; i < monsters.length; i++) {
            if (current + bonus[i] < monsters[i])
                return false;
            current -= monsters[i];
            if (current < 0)
                current = 0;
        }
        return true;
    }
}
