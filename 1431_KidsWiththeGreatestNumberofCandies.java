import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        List<Boolean> list = new ArrayList<>();

        for(int i = 0; i < candies.length; i++){
            if(max < candies[i])
                max = candies[i];
        }

        for(int i = 0; i < candies.length; i++){
            if(max <= candies[i] + extraCandies)
                list.add(true);
            else
                list.add(false);
        }
        return list;
    }
}
