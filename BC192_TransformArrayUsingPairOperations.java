class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long sourceSum = 0;
        long targetSum = 0;

        for(int src: source){
            sourceSum += src;
        }

        for(int trg: target){
            targetSum += trg;
        }

        return sourceSum == targetSum;
    }
}
