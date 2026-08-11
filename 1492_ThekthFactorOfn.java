//My approach : Time complexity- O(n)

class Solution {
    public int kthFactor(int n, int k) {
        ArrayList<Integer> factors = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(n%i==0)
                factors.add(i);
        }
        if(factors.size()<k)
            return -1;
        return factors.get(k-1);
    }
}

//Optimal approach : Time complexity - O(√n)

class Solution {
    public int kthFactor(int n, int k) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }
        for (int i = (int)Math.sqrt(n); i >= 1; i--) {
            if (n % i == 0) {
                int factor = n / i;
                if (factor != i) {
                    k--;
                    if (k == 0) {
                        return factor;
                    }
                }
            }
        }
        return -1;
    }
}
