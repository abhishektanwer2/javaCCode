package Leetcode;

import java.util.*;

public class BannedWords {
    public static void main(String []args){
        String input="Bob hit a ball, the hit BALL flew far after it was hit.";
        String [] bannedwords=new String[]{"hit"};
        Set<String>ban=new HashSet<>();
        for (String bannedword : bannedwords) {
            ban.add(bannedword);}
        StringBuilder s=new StringBuilder();
        String s1=input.toLowerCase().replaceAll("[^a-zA-Z0-9 ]","");
        System.out.println(s1);
        String []inputarray=s1.split(" ");
        HashMap<String ,Integer>map=new HashMap<>();
        for(int i=0;i<inputarray.length;i++){
            if(!ban.contains(inputarray[i])) {
                if (map.containsKey(inputarray[i])) {

                    map.put(inputarray[i], map.get(inputarray[i]) + 1);
                } else {
                    map.put(inputarray[i], 1);
                }
            }

        }
       System.out.println(Collections.max(map.entrySet(),Map.Entry.comparingByValue()).getKey());



    }
}
