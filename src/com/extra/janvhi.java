package com.extra;

public class janvhi {
public static void main(String []args){
    int[][]after={{1,2},{4,4}};
    int[][]before=new int[after.length][after[0].length];
    int s=0;
    int j=0;
    for(int i=0;i<after.length;i++){
        for( j=0;j<after[0].length;j++){
            s=Math.abs(s-after[i][j]);
            before[i][j]=s;
        }
    }
    for (int[] ints : before) {
        System.out.println(ints.toString());
    }
}
}
