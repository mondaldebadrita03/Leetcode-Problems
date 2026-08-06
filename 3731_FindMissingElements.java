import java.util.*;
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=nums[0];
        int max=nums[0];
        HashSet<Integer> set = new HashSet<>();
        for(int x: nums){
            set.add(x);
            max=Math.max(x,max);
            min=Math.min(x,min);
        }
        List<Integer> missing = new ArrayList<>();
        for(int i=min; i<=max; i++){
            if(!set.contains(i))
                missing.add(i);
        }
        return missing;
    }
}
