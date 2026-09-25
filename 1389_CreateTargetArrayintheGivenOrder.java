// Using Manual Insertion
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            for (int j = i; j > index[i]; j--) {
                ans[j] = ans[j - 1];
            }
            ans[index[i]] = nums[i];
        }
        return ans;
    }
}

// Using List

import java.util.ArrayList;
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            target.add(index[i], nums[i]);
        }
        
        for(int i = 0; i < nums.length; i++){
            ans[i] = target.get(i);
        }
        return ans;
    }
}
