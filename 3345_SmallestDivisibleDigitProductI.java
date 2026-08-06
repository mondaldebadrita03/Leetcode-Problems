class Solution {
    public int smallestNumber(int n, int t) {
        int i=n;
        int min=0;
        while(true){
            if(getProduct(i)%t==0)
                return i;
            i++;
        }
    }
    public int getProduct(int x){
        int product=1;
        while(x!=0){
            product*=x%10;
            if (product == 0) return 0; 
            x/=10;
        }
        return product;
    }
}
