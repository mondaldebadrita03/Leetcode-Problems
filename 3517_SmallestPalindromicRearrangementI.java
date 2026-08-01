import java.util.Arrays;
class Solution {
    public String smallestPalindrome(String s) {
        int len = s.length();
        int mid= len / 2 -1;
        char []arr = s.toCharArray();
        Arrays.sort(arr, 0, mid+1);
        for(int i=0; i<=mid; i++){
            arr[len-1-i]= arr[i];
        }
        return new String(arr);
    }
}
