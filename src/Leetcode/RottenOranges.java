package Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
    public static class cell{
        int row;
        int col;
        public cell(int row,int col){
            this.row=row;
            this.col=col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

    }
    public static void main(String []args){
        int[][]grid=new int [][]{{2,1,1},{1,1,0},{0,1,1}};
        Queue<cell>que=new ArrayDeque<>();
        int freshOranges=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    que.offer(new cell(i,j));
                }
                else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        int min=-1;
        que.offer(new cell(-1,-1));
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while(!que.isEmpty()){
            cell c=que.poll();
            int row=c.getRow();
            int col=c.getCol();
            if(row==-1){
                min++;
                if (!que.isEmpty())
                    que.offer(new cell(-1, -1));
            }
            else{
                for(int[] d:directions){
                    int neighbourRow=row+d[0];
                    int neighbourCol=col+d[1];
                    if(neighbourRow>=0&&neighbourRow<grid.length&&neighbourCol>=0&&neighbourCol<grid[0].length){
                        if(grid[neighbourRow][neighbourCol]==1){
                            grid[neighbourRow][neighbourCol]=2;
                            freshOranges--;
                            que.offer(new cell(neighbourRow,neighbourCol));
                        }

                    }
                }

            }
        }
        System.out.println("total minutes"+min);
    }
}
