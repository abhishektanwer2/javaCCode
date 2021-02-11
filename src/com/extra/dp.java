package com.extra;

public class dp {
public static void main(String [] args){
    int n=10;
    int []dparr=new int[n+1];
    System.out.println(nostairs(n,dparr));
}

    private static int nostairs(int n, int[] dparr) {

   dparr[1]=1;
   dparr[2]=2;
   for(int i=3;i<=n;i++){
       dparr[i]=dparr[i-1]+dparr[i-2];
   }
    return dparr[n];
    }


}
