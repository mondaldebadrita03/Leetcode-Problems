class Solution {
    public int calculateScore(int a, int b) {
        String binaryStr1 = Integer.toBinaryString(a);
        String binaryStr2 = Integer.toBinaryString(b);

        int s1 = binaryStr1.length() - binaryStr1.replace("1", "").length();
        int s2 = binaryStr2.length() - binaryStr2.replace("1", "").length();

        if(s1 >= s2){
            return s1 * s2;
        }
        return s1 == 0 ? 0 : s2 / s1;
    }
}
