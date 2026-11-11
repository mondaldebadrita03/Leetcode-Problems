class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if(need1 == 0 && need2 == 0)
            return 0;

        long c1 = (long) cost1 * need1 + (long) cost2 * need2;
        long c2 = Math.max(need1 , need2) * (long) costBoth;
        long c3 = Integer.MAX_VALUE;

        if(need1 > need2){
            c3 = (long) need2 * costBoth + (long) (need1 - need2) * cost1;
        }
        else{
            c3 = (long) need1 * costBoth + (long) (need2 - need1) * cost2;
        }
        return Math.min(c1, Math.min(c2, c3));
    }
}
