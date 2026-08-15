import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        List<Integer> elements = new ArrayList<>(freq.keySet());

        elements.sort((a, b) -> freq.get(b) - freq.get(a));

        int[] ans = new int[k];

        for(int i = 0; i < k; i++)
            ans[i] = elements.get(i);

        return ans;
    }
}
