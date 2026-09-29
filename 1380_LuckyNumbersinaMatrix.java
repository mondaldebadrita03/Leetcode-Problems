class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rowMin = new int[m];

        for(int i = 0; i < m; i++){
            int min = Integer.MAX_VALUE;

            for(int j = 0; j < n; j++){
                min = Math.min(min, matrix[i][j]);
            }
            rowMin[i] = min;
        }

        int[] colMax = new int[n];

        for(int i = 0; i < n; i++){
            int max = Integer.MIN_VALUE;

            for(int j = 0; j < m; j++){
                max = Math.max(max, matrix[j][i]);
            }
            colMax[i] = max;
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }

        return ans;
    }
}
