class Solution {
    public int countSpecialIntegers(int[] nums) {
        int count = 0;
        int[] freq = new int[101];

        for(int num: nums){
            freq[num]++;
        }

        for(int i = 1; i <= 100; i++){
            if(freq[i] == 3){
                int index = 0;
                int[] occurrences = new int[3];

                for(int j = 0; j < nums.length; j++){
                    if(nums[j] == i){
                        occurrences[index++] = j;
                    }
                }
                if(occurrences[1] - occurrences[0] == occurrences[2] - occurrences[1])
                    count++;
            }
        }
        return count;
    }
}
