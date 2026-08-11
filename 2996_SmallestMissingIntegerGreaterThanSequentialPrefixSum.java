import java.util.HashSet;
class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        int prefixSum = nums[0];
        int i = 1;
        while (i < nums.length && nums[i] == nums[i - 1] + 1) {
            prefixSum += nums[i];
            i++;
        }
        while (s.contains(prefixSum)) {
            prefixSum++;
        }
        return prefixSum;
    }
}
