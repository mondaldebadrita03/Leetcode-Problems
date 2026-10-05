class Solution {
    public int minRotations(String s) {
        int j = 0;
        int rotations = 0;

        for(int i = 0; i < 10; i++){
            int curr = s.charAt(i) - '0';
            rotations += Math.min(Math.abs(curr - j), 10 - Math.abs(curr - j));
            j = curr;
        }
        return rotations;
    }
}
