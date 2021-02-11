package com.extra;

class Solution {
    int[][] g;
    int[][] dp;
    int x; // grid width
    int y; // grid height

    public  static  void main(String [] args){
        Solution s=new Solution();
        int[][] arr={{1,3,1},{1,5,1},{4,2,1}};
       System.out.println( s.minPathSum(arr));
    }

    public int minPathSum(int[][] grid) {
        this.g = grid;
        this.y = grid.length;

        if (this.y == 0)
            return 0;

        this.x = grid[0].length;

        this.dp = new int[this.y][this.x];

        // fill value with -1
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        }

        return recursion(0, 0);
    }

    private int recursion(int i, int j) {
        if (i >= this.y || j >= this.x)
            return Integer.MAX_VALUE;

        if (i == this.y - 1 && j == this.x - 1)
            return this.g[i][j];

        if (this.dp[i][j] != -1)
            return this.dp[i][j];

        int sum = this.g[i][j] + Math.min(recursion(i + 1, j), recursion(i, j + 1));
        this.dp[i][j] = sum;

        return sum;
    }


}
