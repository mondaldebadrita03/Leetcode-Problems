class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry=0;
        StringBuilder s = new StringBuilder("");
        while(i>=0|| j>=0 || carry==1){
            int sum = carry;
            if(i>=0){
                sum += a.charAt(i) - '0';
                i--;
            }
            if(j>=0){
                sum += b.charAt(j) - '0';
                j--;
            }
            carry = sum / 2;
            s.insert(0, sum % 2);
        }
        return s.toString();
    }
}
