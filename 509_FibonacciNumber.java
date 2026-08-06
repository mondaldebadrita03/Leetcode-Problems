class Solution {
    public int fib(int n) {
        if(n<2)
            return n;
        if(n==2)
            return 1;
        int a=0;
        int b=1;
        int count=2;
        while(count<=n){
            int temp=b;
            b+=a;
            a=temp;
            count++;
        }
        return b;
    }
}
