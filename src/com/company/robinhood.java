package com.company;

import java.util.*;

public class robinhood {
    static HashSet<Integer>hash=new HashSet<>();
    public static void main(String []args){
       // Scanner s=new Scanner(System.in);
        /*digit manipulation
int number;

        number=s.nextInt();
        digitmanipulation(number);*/

/*deleteminimalpeak
int n;
n=s.nextInt();
int[]arr=new int[n];
for(int i=0;i<arr.length;i++){
    arr[i]=s.nextInt();
}
        Integer[]arr={1,1};
        deleteminimumpeak(arr);*/


       /* suffle pieces
       int []arr={1,2,4,3,5};
        int[][]pieces=new int [][]{{4},{1,2},{3,5}};
     System.out.print( sufflepieces(pieces,arr));*/


        /*almost substring
        String t="azzzccabzdcabzdc";
        String s="azc";
      System.out.print(  almostsubstring(s,t));


*/

      /* deviser substring
      Integer k=5341;
        int n=2;
        distinctsubstring(n,k);*/

       int  num[][]=new int[][]{{1, 2, 3, 2, 5, 7},{4, 5, 6, 1, 7, 6},{7, 8, 9, 4, 8, 3}};
      mainfunction(num);


    }

    private static boolean[] mainfunction(int[] []numbers) {
        int n=numbers[0].length;
       // ArrayList<Boolean>output=new ArrayList<>();
        boolean[]output=new boolean[n-2];
        for(int i=0;i<n-2;i++){
            ArrayList<Integer>nums=new ArrayList<>();
            nums.add(numbers[0][i]);
            nums.add(numbers[0][i + 1]);
            nums.add(numbers[0][i + 2]);
            nums.add(numbers[1][i]);
            nums.add(numbers[1][i + 1]);
            nums.add(numbers[1][i + 2]);
            nums.add(numbers[2][i]);
            nums.add(numbers[2][i + 1]);
            nums.add(numbers[2][i + 2]);
            ArrayList<Boolean>result=new ArrayList<>();
            for(int j=1;j<=9;j++){
                if(nums.contains(j)){
                    result.add(true);
                }
                else{
                    result.add(false);
                }
            }
            if(result.contains(false)){
                output[i]=false;
            }
            else{
                output[i]=true;
            }

        }return output;
    }

    private static void distinctsubstring(int n, Integer k) {

  System.out.print(genrateallnumwithn(n,  k.toString().toCharArray(),k));
    }

    public static int genrateallnumwithn(int n, char[] k, Integer integer) {
ArrayList<String>add=new ArrayList<>();
            for (int i = 0; i < k.length-1; i++) {
                String temp=k[i]+"";
              for(int j=i+1;j<i+n;j++){

                  temp+=""+k[j];

              }
              if(temp.length()==n){
                  if(Integer.parseInt(temp)!=0) {
                      if (integer % Integer.parseInt(temp) == 0) {
                          hash.add(Integer.parseInt(temp));
                      }
                  }

              }

            }
            return hash.size();

    }

    private static int almostsubstring(String s, String t) {
        int count=0;
        if(t.length()>4){
            for(int i=0;i<t.toCharArray().length-4;i++){
                String temp=t.charAt(i)+""+t.charAt(i+2)+""+t.charAt(i+4);
                if(temp.equals(s)){
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean sufflepieces(int[][] pieces, int[] arr) {
        int match=0;
        for (int[] piece : pieces) {
            int found=0;
            for(int i=0;i<arr.length;i++){
                if(piece[0]==arr[i]){
                    found =i;
                    break;
                }
                else if(i==arr.length&&piece[0]!=arr[i])return false;
            }
            int total=0;
            for(int i=0;i< piece.length;i++){
                if(piece[i]==arr[found]){
                    total++;
                    found++;
                }
            }
            match+=total== piece.length?total:0;


        }
        return match== arr.length;
    }

    private static ArrayList<Integer> deleteminimumpeak(Integer[] arr) {

        ArrayList<Integer>result=new ArrayList<>();
        ArrayList<Integer>mainarr=new ArrayList<>();
       for (Integer integer : arr) {
       mainarr.add(integer);
        }

       while(mainarr.size()>1) {
           int min=Integer.MAX_VALUE;
           for (int i = 0; i < mainarr.size() ; i++) {
               if(i==0){
                   if (mainarr.get(i + 1) < mainarr.get(i)){
                       min=Math.min(min,mainarr.get(i));
                   }
               }
            else if(i==mainarr.size()-1){
                  if (mainarr.get(i - 1) < mainarr.get(i)){
                      min=Math.min(min,mainarr.get(i));
                  }
               }
               else if (mainarr.get(i-1) < mainarr.get(i) && mainarr.get(i + 1) < mainarr.get(i)) {
                       min = Math.min(min, mainarr.get(i));


               }

           }
           if(min!=Integer.MAX_VALUE){
               result.add (min);
               mainarr.remove(Integer.valueOf(min));
           }


           //minumpeaks.remove(minumpeaks);
       }
       result.add(mainarr.get(0));
        return  result;
        }

    private static int digitmanipulation(int number) {
        int sum=0,product=1;
        while(number>0){

            int num=number%10;
            sum+=num;
            product*=num;
            number=number/10;
        }
        return product-sum;
    }


}
