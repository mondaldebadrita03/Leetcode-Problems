// Approach 1 : T.C: O(n2)
// Easy to Visualise

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i + j == n - 1 || i == j){
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }
}


// Approach 2: T.C : O(n)

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        for(int i = 0; i < n; i++){
            sum += mat[i][i];

            if(i != n - i - 1)
                sum += mat[i][n - i - 1];
        }
        return sum;
    }
}
