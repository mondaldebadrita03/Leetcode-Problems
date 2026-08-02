//works optimally for the particular problem with the special constraints
class Solution {
    public boolean stoneGame(int[] piles) {
        return true; 
    }
}
//works in all cases
class Solution {
    public boolean stoneGame(int[] piles) {
        return(getGap(piles,0,piles.length-1))>0;
    }
    private int getGap(int[] a, int i, int j){
        if(i==j)
            return a[i];
        int pickLeft = a[i] - getGap(a,i+1,j);
        int pickRight = a[j] - getGap(a,i,j-1);
        return Math.max(pickLeft,pickRight);
        
    }
}
