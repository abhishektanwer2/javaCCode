package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Amazon1 {

  public static void main(String[]args){
      int[][]arr={{1,2},{2,3},{4,5}};
      int row=3,col=2;
      int sum=9;


      ArrayList<Long>result=new ArrayList<>();
      checksum(row,col,arr,sum);
  }
  public static   long[] matrixQueries(int n, int m, int[][] queries) {
      int[][] board = new int[n][m];
      ArrayList<Long> result = new ArrayList<>();
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              board[i][j] = (i + 1) * (j + 1);

          }
      }
      for (int i = 0; i < queries.length; i++) {
          if (queries[i][0] == 0) {
              calculatemin(result, queries);
          }
      }
return new long[5];
  }

    private static void calculatemin(ArrayList<Long> result, int[][] queries) {
    }

    private static Boolean checksum(int row, int col, int[][] arr, int sum) {
        Set<Integer>hash=new HashSet<>();
      for(int i=0;i<row;i=i++){

      }
      return false;
    }

}
