class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxQuantity = 0;

        while(i < j){
            int currentQuantity = Math.min(height[i], height[j]) * (j - i);
            maxQuantity = Math.max(maxQuantity, currentQuantity);
            
            if(height[i] < height[j])
                i++;
            else
                j--;
        }
        return maxQuantity;
    }
}
