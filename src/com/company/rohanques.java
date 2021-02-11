package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class rohanques {
 // static   int[][] input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    public static void main(String[]args){
       /* String[]words={"encourage"};
        HashMap<String ,List<String>>sy=new HashMap<String, List<String>>();
        List<String>sym=new ArrayList<>()  ;
        sym.add("urge");
        sym.add("age");
        sym.add("inspire");
        sy.put("encourage",sym);
        HashMap<String , List<String>>an=new HashMap<String, List<String>>();
        List<String>dym=new ArrayList<>()  ;
        dym.add("discourage");
        dym.add("cou");
        an.put("encourage",dym);

        int count=0;
        for(int i=0;i< words.length;i++){
         count+=   checksyn(words[i],sy);
            count-=checkanton(words[i],an);
        }*/
      
//main diagonal problem
       /* int[] q = new int[]{0, 1, 2};
        for (int i = 0; i < q.length; i++) {
            switch (q[i]){
                case 0:
                    rotateclockwise(input);
                    break;
                case 1:
                    maindiagonal(input);
                    break;
                case 2:
                    secondarydiagonal(input);
                    break;
            }

            for (int[] ints : input) {
                for (int anInt : ints) {
                   System.out.print(anInt);
                }
                System.out.println();
            }
        }*/

        ArrayList<Integer>landingtimelist=new ArrayList<>();
        landingtimelist.add(630);
        landingtimelist.add(645);
        landingtimelist.add(730);
        landingtimelist.add(1100);

        ArrayList<Integer>takeofftimelist=new ArrayList<>();
        takeofftimelist.add(700);
        takeofftimelist.add(845);
        takeofftimelist.add(1015);
        takeofftimelist.add(1130);
        int initialplanes=1;
        int maxtimewait=1;

        int lp=0;
        int tp=0;
        int count=initialplanes;
        int ocupiedgate=count;

        while(lp<landingtimelist.size()&&tp<takeofftimelist.size()){

        if(landingtimelist.get(lp)<takeofftimelist.get(tp)){
            if(adjustTimes(landingtimelist.get(lp)+maxtimewait)<takeofftimelist.get(tp)){

                if(ocupiedgate<count){
                    ocupiedgate++;
                }
                else{
                    count++;
                    ocupiedgate++;

                }
               // landingtimelist.remove(lp++);
                lp++;
            }
            else{
               // takeofftimelist.remove(tp++);

                if(ocupiedgate<count){
                    ocupiedgate++;
                }
                else{
                    count++;
                    ocupiedgate++;

                }

            }
        }
        else{
            ocupiedgate--;
            tp++;

        }
        }
        while (tp < landingtimelist.size()) {
            ocupiedgate++;
            count = Math.max(count, ocupiedgate);
            tp++;
        }
        System.out.println(count);


    }
    public static int adjustTimes(int time) {
        int temp = time % 100;
        if (temp > 59) {
            int diff = temp - 60;
            time = time / 100;
            time = (time + 1) * 100 + diff;
        }
        return time;
    }
/*

    private static void maindiagonal(int[][] input) {
    }

    private static void secondarydiagonal(int[][] input) {
    }

    private static void rotateclockwise(int[][] input) {
        transpose_matrix(input);
        reverse_rows(input);
    }

    public static void reverse_rows(int mat[][])
    {
        int k;
        for (int i = 0; i < mat.length; i++)
        {
            k = mat.length-1;
                for (int j = 0; j < k; j++)
            {
                int temp = mat[i][j];
                mat[i][j] = mat[i][k];
                mat[i][k] = temp;
                k--;
            }}}
    public static void transpose_matrix(int mat[][])
    {
        int i,j;
        for(i=0;i<mat.length;i++)
        {
            for(j=i;j<mat.length;j++)
            {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }}}
*/



    /*private static int checksyn(String word, HashMap<String, List<String>> sy) {
    int countsyn=0;

    if(sy.containsKey(word)){

        for(int i=0;i<sy.get(word).size();i++){
            String ele=sy.get(word).get(i);
            int p2=0;
            for(int j=0;j<word.length();j++){
                if(word.charAt(j)== ele.charAt(p2)) {
                    p2++;
                    if(p2==ele.length())break;
                }
            }
            if(p2==ele.length()){
                countsyn++;
            }
        }
    }
        return countsyn;
    }

    private static int checkanton(String word, HashMap<String, List<String>> an) {
    int countan=0;
        if(an.containsKey(word)){
            for(int i=0;i<an.get(word).size();i++){
                String ele=an.get(word).get(i);
                int p2=0;
                for(int j=0;j<word.length();j++){

                    if(word.charAt(j)== ele.charAt(p2)) {
                        p2++;

                        if(p2==ele.length())break;
                    }
                }
                if(p2==ele.length()){
                    countan++;
                }
            }
        }
    return countan;
    }*/
}
