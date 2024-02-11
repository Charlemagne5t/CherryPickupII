public class Solution {
    public int cherryPickup(int[][] grid) {
        Integer[][][] memo = new Integer[grid.length + 1][grid[0].length + 1][ grid[0].length + 1];
        return dfs(grid, 0, 0, grid[0].length  - 1, memo);
    }

    private int dfs(int[][] grid, int i, int j1, int j2, Integer[][][] memo){
        if(i == grid.length){
            return 0;
        }
        if(memo[i][j1][j2] != null){
            return memo[i][j1][j2];
        }

        int firstLeftSecondLeft = 0;
        int firstLeftSecondDown = 0;
        int firstLeftSecondRight = 0;
        int firstDownSecondLeft = 0;
        int firstDownSecondDown = 0;
        int firstDownSecondRight = 0;
        int firstRightSecondLeft = 0;
        int firstRightSecondDown = 0;
        int firstRightSecondRight = 0;

        if(j1 > 0 && j2 > 0){
            if(j1  != j2){
                firstLeftSecondLeft = grid[i][j1] + grid[i][j2] + dfs(grid, i + 1, j1 - 1, j2 - 1, memo);
            }else{
                firstLeftSecondLeft = grid[i][j1] + dfs(grid, i + 1, j1 - 1, j2 - 1, memo);
            }

        }

        if(j1 > 0){
            if(j1  != j2){
                firstLeftSecondDown = grid[i][j1] + grid[i][j2] + dfs(grid, i + 1, j1 - 1, j2, memo);
            }else{
                firstLeftSecondDown = grid[i][j1] + dfs(grid, i + 1, j1 - 1, j2, memo);
            }
        }
        if(j1 > 0 && j2 < grid[i].length - 1){
            if(j1  != j2){
                firstLeftSecondRight = grid[i][j1] + grid[i][j2] + dfs(grid, i + 1, j1 - 1, j2 + 1, memo);
            }else{
                firstLeftSecondRight = grid[i][j1] + dfs(grid, i + 1, j1 - 1, j2 + 1, memo);
            }
        }

        if(j2 > 0){
            if(j1  != j2){
                firstDownSecondLeft = grid[i][j1] + grid[i][j2] + dfs(grid, i + 1, j1, j2 - 1, memo);
            }else{
                firstDownSecondLeft = grid[i][j1] + dfs(grid, i + 1, j1, j2 - 1, memo);
            }
        }
        if(j1  != j2){
            firstDownSecondDown = grid[i][j1] + grid[i][j2] + dfs(grid, i + 1, j1, j2, memo);
        }else{
            firstDownSecondDown = grid[i][j1] + dfs(grid, i + 1, j1, j2, memo);
        }

        if(j2 < grid[i].length - 1){
            if(j1  != j2){
                firstDownSecondRight = grid[i][j1] + grid[i][j2] + dfs(grid, i + 1, j1, j2 + 1, memo);
            }else{
                firstDownSecondRight = grid[i][j1] + dfs(grid, i + 1, j1, j2 + 1, memo);
            }
        }

        if(j1 < grid[i].length - 1 && j2 > 0){
            if(j1  != j2){
                firstRightSecondLeft = grid[i][j1] + grid[i][j2] + dfs(grid, i + 1, j1 + 1 ,j2 -1, memo);
            }else{
                firstRightSecondLeft = grid[i][j1] + dfs(grid, i + 1, j1 + 1, j2 -1, memo);
            }
        }
        if(j1 < grid[i].length - 1){
            if(j1  != j2){
                firstRightSecondDown = grid[i][j1] + grid[i][j2] + dfs(grid, i + 1, j1 + 1, j2, memo);
            }else{
                firstRightSecondDown = grid[i][j1] + dfs(grid, i + 1, j1 + 1, j2, memo);
            }
        }

        if(j1 < grid[i].length - 1 && j2 < grid[i].length - 1 ){
            if(j1  != j2){
                firstRightSecondRight = grid[i][j1] + grid[i][j2] + dfs(grid, i + 1, j1 + 1, j2 + 1, memo);
            }else{
                firstRightSecondRight = grid[i][j1] + dfs(grid, i + 1, j1 + 1, j2 + 1, memo);
            }
        }
        int result = 0;


        int res1 = Math.max(firstLeftSecondLeft, Math.max(firstLeftSecondDown, firstLeftSecondRight));
        int res2 = Math.max(firstDownSecondLeft, Math.max(firstDownSecondDown, firstDownSecondRight));
        int res3 = Math.max(firstRightSecondLeft, Math.max(firstRightSecondDown, firstRightSecondRight));
        result = Math.max(res1, Math.max(res2, res3));
        memo[i][j1][j2] = result;
        return result;

    }
}
