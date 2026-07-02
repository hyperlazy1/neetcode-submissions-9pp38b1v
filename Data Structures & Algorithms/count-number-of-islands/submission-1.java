class Solution {
    private static final int[] r = {-1,0,1,0};
    private static final int[] c = {0,-1,0,1};

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j,n,m);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int n, int m){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]=='0') return;

        grid[i][j] = '0';

        for(int k=0;k<4;k++){
            dfs(grid,i+r[k],j+c[k],n,m);
        }
    }
}
