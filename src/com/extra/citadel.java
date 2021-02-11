package com.extra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class citadel {

    public static class people {
        int id;
        int biddingprice;
        int time;
        int totalshare;

        public people(int id, int totalshare,int biddingprice, int time ) {
            this.id = id;
            this.biddingprice = biddingprice;
            this.time = time;
            this.totalshare = totalshare;
        }

        @Override
        public String toString() {
            return "people{" +
                    "id=" + id +
                    ", biddingprice=" + biddingprice +
                    ", time=" + time +
                    ", totalshare=" + totalshare +
                    '}';
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> result = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        ArrayList<people> peopleArrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {

            int id = s.nextInt();
            int numshare = s.nextInt();
            int bid = s.nextInt();
            int timest = s.nextInt();

            people p1 = new people(id, numshare, bid, timest);
            peopleArrayList.add(p1);

        }
        int totashare = s.nextInt();
        System.out.println(distributeshare(peopleArrayList, result, totashare).toArray());

    }

    private static ArrayList<Integer> distributeshare(ArrayList<people> peopleArrayList, ArrayList<Integer> result, int totashare) {
        peopleArrayList.sort(new Comparator<people>() {
            @Override
            public int compare(people o1, people o2) {
                if(o1.biddingprice != o2.biddingprice)
                    return o2.biddingprice - o1.biddingprice;
                else if(o1.time != o2.time)
                    return o1.time - o2.time;
                else if(o1.totalshare != o2.totalshare)
                    return o2.totalshare - o1.totalshare;
                return 0;
            }
        });

        for(int i=0;i<peopleArrayList.size();i++){
            ArrayList<people>temp=new ArrayList<>();
            for(int j=i+1;j<peopleArrayList.size();j++){
                temp.add(peopleArrayList.get(i));
                if(peopleArrayList.get(i).biddingprice==peopleArrayList.get(j).biddingprice){
                    temp.add(peopleArrayList.get(j));
                }
            }int count=0;
            for (people people : temp) {
               count+=people.totalshare;

            }
            if(count>totashare && totashare>temp.size())
            {
                for (people people : temp) {
                    peopleArrayList.remove(people);


                }
                totashare-=count;
            }
            else if(totashare<=temp.size()){
                for(int j=0;j<totashare;j++){
                    peopleArrayList.remove(0);

                }
                totashare=0;
            }
           else if(totashare<count){
                for (people people : temp) {
                    peopleArrayList.remove(people);


                }
                totashare-=count;
            }

        }

        while(totashare > 0 && !peopleArrayList.isEmpty()) {
            totashare -= peopleArrayList.get(0).totalshare;
            peopleArrayList.remove(0);
        }
        while(!peopleArrayList.isEmpty())
            result.add(peopleArrayList.remove(0).id);
        Collections.sort(result);
        return result;
    }
}

