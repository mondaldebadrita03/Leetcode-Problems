class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];

        int minOccurrences = n / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for(int num: nums){
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);

            if(count > minOccurrences){
                ans = num;
                break;
            }
        }
        return ans;
    }
}
