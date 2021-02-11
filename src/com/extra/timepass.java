package com.extra;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class timepass {

    public static void main(String[] args) {
        /*HashMap<Integer, Integer> hash = new HashMap<>();
        int count = 0;
        int[] arr = {32, 332, 100};
        for (int i = 0; i < arr.length; i++) {
            hash.putIfAbsent(arr[i], reverser(arr[i]));
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                if (arr[i] + hash.get(arr[j]) == arr[j] + hash.get(arr[i])) {
                    count++;
                }

            }

        }
        System.out.println(count);*/

        HashMap<Integer,Integer>hash=new HashMap<>();
      int N=20;
      boolean[]dp=new boolean[N+1];
   System.out.println(dpsolution(N,dp));

    }

    private static boolean dpsolution(int N, boolean[] dp) {
        for(int i=1;i<=N;i++){
            for(int j=1;j<i;j++){
                if(i%j==0){
                    if(!dp[i-j]) {
                        dp[i] = true;
                        break;
                    }

                }
            }
        }
        return dp[N];
    }


    public static int reverser(int num) {
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }


}


