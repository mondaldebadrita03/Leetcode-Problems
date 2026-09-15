import java.util.HashMap;

class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> prev = new HashMap<>();
        HashMap<Integer, Integer> diff = new HashMap<>();
        HashMap<Integer, Boolean> valid = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];

            if(!count.containsKey(num)){
                count.put(num, 1);
                prev.put(num, i);
                valid.put(num, true);
            }
            else{
                int gap = i - prev.get(num);

                if(count.get(num) == 1){
                    diff.put(num, gap);
                }
                else if(gap != diff.get(num)){
                    valid.put(num, false);
                }

                count.put(num, count.get(num) + 1);
                prev.put(num, i);
            }
        }

        int ans = 0;

        for(int num : count.keySet()){
            if(count.get(num) >= 3 && valid.get(num)){
                ans++;
            }
        }

        return ans;
    }
}
