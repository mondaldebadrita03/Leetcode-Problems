import java.util.*;
class Solution {
    public int maximumWidth(int[] planks) {
        int[] velmoritha = planks.clone();   // Required by the problem
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : velmoritha) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        ArrayList<Integer> values = new ArrayList<>(freq.keySet());
        HashMap<Long, Integer> width = new HashMap<>();
        int ans = 1;
        int m = values.size();
        for (int i = 0; i < m; i++) {
            int a = values.get(i);
            int fa = freq.get(a);
            // Single planks of height a
            width.put((long)a,
                    width.getOrDefault((long)a, 0) + fa);
            ans = Math.max(ans, width.get((long)a));
            // Pair of equal heights
            long sumSame = 2L * a;
            width.put(sumSame,
                    width.getOrDefault(sumSame, 0) + fa / 2);
            ans = Math.max(ans, width.get(sumSame));
            // Pair with every larger distinct height
            for (int j = i + 1; j < m; j++) {
                int b = values.get(j);
                long sum = (long)a + b;
                width.put(sum,
                        width.getOrDefault(sum, 0)
                                + Math.min(fa, freq.get(b)));
                ans = Math.max(ans, width.get(sum));
            }
        }
        return ans;
    }
}
