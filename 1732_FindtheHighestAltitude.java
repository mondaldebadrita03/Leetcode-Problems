class Solution {
    public int largestAltitude(int[] gain) {
        int highest = gain[0] > 0 ? gain[0]: 0;

        for(int i = 1; i < gain.length; i++){
            gain[i] = gain[i] + gain[i - 1];
            highest = Math.max(highest, gain[i]);
        }
        return highest;
    }
}
