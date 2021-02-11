package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class cita {
    public static void main(String []args){
       /* List<Integer>inputs=new ArrayList<>();
        inputs.add(1);
        inputs.add(1);
        inputs.add(1);
        inputs.add(1);
        inputs.add(20);
        droppedRequests(inputs);*/

    }
    public static List<List<Integer>> findBeforeMatrix(List<List<Integer>> after) {
        for(int i=0; i<after.size(); i++) {
            for(int j=0; j<after.get(0).size(); j++) {

                callmethod(i,j,after);
            }


        }

        for(int i=0; i<after.size(); i++) {
            for(int j=0; j<after.get(0).size(); j++) {

                after.get(i).set(j,-after.get(i).get(j));
            }



        }

        return after;
    }

    public static void callmethod(int x,int y,List<List<Integer>> after){
        int s=0;
        for (int i = 0; i <=x; i += 1) {
            for (int j = 0; j <=y; j += 1) {
                s=s-after.get(i).get(j);
            }
        }
        after.get(x).set(y,s);

    }

    public static int droppedRequests(List<Integer> requestTime) {
        HashMap<Integer,Integer>hash=new HashMap<>();
        HashMap<Integer,Integer>look=new HashMap<>();
        if(requestTime.size()<=3){
            return 0;
        }
        for (Integer integer : requestTime) {
            if(hash.containsKey(integer)){
                hash.put(integer,hash.get(integer)+1);
            }
            else{
                hash.put(integer,1);
            }
        }

        for(int i=requestTime.get(0);i<=requestTime.get(requestTime.size()-1)+1;i++){
            look.put(i,look.getOrDefault(i-1,0)+hash.getOrDefault(i,0));

        }

        for(int i=3;i<requestTime.size();i++){
            int temp1=0,temp2=0;
           if(look.containsKey(requestTime.get(i)-10))temp1=look.get(requestTime.get(i)-10);
            if(look.containsKey(requestTime.get(i)-60))temp2=look.get(requestTime.get(i)-60);
           if(requestTime.get(i)==requestTime.get(i-3))requestTime.set(i-3,Integer.MIN_VALUE);
           else if(i+1-temp1>20){
               requestTime.set(i,Integer.MIN_VALUE);
           }
           else if(i+1-temp2>60){
               requestTime.set(i,Integer.MIN_VALUE);
           }
        }
        int count=0;
        for (Integer integer : requestTime) {
            if(integer==Integer.MIN_VALUE){
                count++;
            }
        }
        return count;



    }



}
