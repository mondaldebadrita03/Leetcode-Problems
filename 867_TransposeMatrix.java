class Solution {
    public int[][] transpose(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] mat = new int[n][m];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // if(i != j){              // This approach is only gonna work for n * n matrix, not for m * n
                //     int temp = matrix[i][j];
                //     matrix[i][j] = matrix[j][i];
                //     matrix[j][i] = temp;
                // }
                mat[j][i] = matrix[i][j];  // or mat[i][j] = matrix[j][i];
            }
        }
        return mat;
    }
}
