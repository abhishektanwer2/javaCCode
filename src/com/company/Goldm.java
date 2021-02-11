package com.company;

import java.util.ArrayList;
import java.util.List;

public class Goldm {
    public static void main(String []args){
List<String>related=new ArrayList<>();
related.add("1100");
related.add("1110");
related.add("0110");
related.add("0001");
countGroups(related);
    }

    public static int countGroups(List<String> related) {
        // Write your code here
        int row=related.size();
        int col=related.get(0).length();
        int grid[][]=new int[row][col];
        for(int i=0;i<row;i++ ){
            for(int j=0;j<col;j++){
                grid[i][j]=Integer.parseInt(related.get(i).charAt(j)+"");

            }

        }
        System.out.println(Math.floorMod(1,4));
        return 0;
    }

}

