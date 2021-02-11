package com.extra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IMC {

    public static void main(String[] args) {

        //Scanner s=new Scanner(System.in);
        String artificats = "1A 2A,12A 12B";
        String searched = "12A";
        int N = 12;

        solution(N, artificats, searched);
        // System.out.println("hello worlds");
    }

    //extra function write here


    public static int[] solution(int N, String artificats, String searched) {
        String[] elements = artificats.split(",");
        Map<Integer, ArrayList<String>> elementpositions = new HashMap<>();

        for (int i = 0; i < elements.length; i++) {
            String[] str = elements[i].split(" ");
            ArrayList<String> temp = new ArrayList<>();


            for (int j = str[0].charAt(str[0].length() - 1) - 'A'; j <= str[1].charAt(str[1].length() - 1) - 'A'; j++) {
                for (int k = Integer.parseInt(str[0].substring(0, str[0].length() - 1)) - 1; k < Integer.parseInt(str[1].substring(0, str[1].length() - 1)); k++) {
                    char c = (char) (j + 'A');
                    String s = Integer.toString(k + 1) + Character.toString(c);
                    temp.add(s);

                }
            }
            elementpositions.put(i, temp);
        }
        int firstcount = 0;
        int secondcount = 0;
        String[] searchedarray = searched.split(" ");
        for (int i = 0; i < elementpositions.size(); i++) {
            ArrayList<String> tempos = elementpositions.get(i);
            int tempolength = tempos.size();
            for (int j = 0; j < tempos.size(); j++) {
                String ele = tempos.get(j);
                for (int k = 0; k < searchedarray.length; k++) {
                    if (searchedarray[k].equals(ele)) {
                        tempos.remove(ele);
                        j--;
                        break;

                    }

                }

            }
            if (tempos.size() == 0) {
                secondcount++;
            } else if (elementpositions.get(i).size() < tempolength) {
                firstcount++;
            }
        }
        int[] finalarray = {firstcount, secondcount};
        return finalarray;
    }


}







