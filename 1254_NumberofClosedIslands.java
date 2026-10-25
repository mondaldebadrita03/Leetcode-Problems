class Solution {
    int n, m;

    public int closedIsland(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    if(dfs(grid, i, j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid, int i, int j){
        if(i >= m || i < 0 || j >= n || j < 0){
            return false;
        }

        if(grid[i][j] == 1){
            return true;
        }

        grid[i][j] = 1;

        boolean up_closed = dfs(grid, i - 1, j);
        boolean down_closed = dfs(grid, i + 1, j);
        boolean left_closed = dfs(grid, i, j - 1);
        boolean right_closed = dfs(grid, i, j + 1);

        return up_closed && down_closed && left_closed && right_closed;
    }
}
