// Approach 1 (Easy to Understand)

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        BigInteger x = BigInteger.ZERO;
        int n = num.length;
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            BigInteger digit = BigInteger.valueOf(num[i]);
            BigInteger power = BigInteger.TEN.pow(n - i - 1);
            x = x.add(digit.multiply(power));
            // x += num[i] * Math.pow(10.0, n - i - 1);
        }
        // x += k;
        x = x.add(BigInteger.valueOf(k));

        if(x.equals(BigInteger.ZERO)) {
            ans.add(0);
            return ans;
        }

        while(x.compareTo(BigInteger.ZERO) > 0){
            int digit = x.mod(BigInteger.TEN).intValue(); 
            ans.add(0, digit);
            x = x.divide(BigInteger.TEN); 
            // int digit = (int)(x % 10L);
            // ans.add(0, digit);
            // x /= 10;
        }

        return ans;
    }
}


// Approach 2

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int i = num.length - 1;

        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
                i--;
            }
            
            ans.add(k % 10); 
            k /= 10;         
        }

        Collections.reverse(ans);
        return ans;
    }
}
