import java.util.Arrays;
class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        double discount = 0.0;
        double minPossiblePrice=0.0;
        int p = prices.length;
        int d = discounts.length;
        int j= 0;
        for(int i=0; i<p; i++){
            if(p<=d){
                discount = prices[p-i-1]*(100.0-discounts[d-i-1])/100;
            }else{
                if (j < d){
                    discount = prices[p-i-1]*(100.0-discounts[d-1-j])/100;
                    j++;
                }else{
                    discount = prices[p-i-1];
                }
            }
            minPossiblePrice+=discount;
        }
        return minPossiblePrice;
    }
}
