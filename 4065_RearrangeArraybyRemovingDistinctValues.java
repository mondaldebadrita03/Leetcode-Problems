import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] freq = new int[101];
        List<Integer> ans = new ArrayList<>();
        int min = 101;
        int max = 0;
        
        for(int i = 0; i < nums.length; i++){
            freq[nums[i]]++;
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int freqCount = 0;
        for(int i = min; i <= max; i++){
            if(freq[i] > 0){
                ans.add(i);
                freqCount++;
            }
            freq[i]--;
            
            if(i == max && freqCount != 0){
                i = i % max;
                freqCount = 0;
            }

            if(i == max && freqCount == 0)
                break;
        }
        
        int[] result = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            result[i] = ans.get(i);
        }
        return result;
    }
}
