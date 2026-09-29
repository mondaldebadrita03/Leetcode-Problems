class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] yearChanges = new int[101];

        for(int[] log: logs){
            int birth = log[0];
            int death = log[1];

            yearChanges[birth - 1950]++;
            yearChanges[death - 1950]--;
        }

        int maxPop = 0;
        int curPop = 0;
        int earliestYear = 1950;

        for(int i = 0; i < yearChanges.length; i++){
            curPop += yearChanges[i];
            if(maxPop < curPop){
                maxPop = curPop;
                earliestYear = 1950 + i;
            }
        }
        
        return earliestYear;
    }
}
