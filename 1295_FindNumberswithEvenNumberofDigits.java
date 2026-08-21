//Approach 1

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
            if((num +"").length() % 2 == 0)
            // if(Integer.toString(num).length() % 2 == 0)
                count++;
        }
        return count;
    }
}

//Approach 2

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
          int digits = (int) Math.log10(num) + 1;
            if(digits % 2 == 0)
                count++;
        }
        return count;
    }
}

//Approach 3

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
          if(num >= 10 && num <= 99 || num >= 1000 && num <= 9999 || num == 100000)
                count++;
        }
        return count;
    }
}
