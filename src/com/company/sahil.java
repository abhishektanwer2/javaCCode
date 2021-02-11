package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class sahil {
    public static void main(String[] args){
       String[]map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        int[]digits={0,1,3,4,5,6,7};
        String []words={"abc","gdef","x"};
        workingbutton(digits,words,map);

    }
    public static boolean[]workingbutton(int[] digits, String[] words, String[] hashMap){
        boolean[]result=new boolean[words.length];
        StringBuilder st=new StringBuilder();
       for(int i=0;i< digits.length;i++){
           st.append(hashMap[digits[i]]);
       }
        st.toString();
        for(int i=0;i<words.length;i++) {
            int k = 0;
            for (int j = 0; j < st.length(); j++) {
                if (k > words[i].length() - 1) {
                    break;
                }
                if (st.indexOf(String.valueOf(words[i].charAt(k))) > 0) {
                    result[i] = true;
                    break;
                }


                k++;

            }

        }
        return result;
        }

    }




