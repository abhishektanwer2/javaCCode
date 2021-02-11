package Leetcode;

import java.util.*;

public class StringSort implements  Comparable<StringSort>{
static HashMap<Character,Integer>hashMap=new HashMap<>();
    public static void main(String[]args){
        String s="tee";
        System.out.print(Strinsortmethod(s));
    }

    private static String Strinsortmethod(String s) {
        char[] chararray=s.toCharArray();
        PriorityQueue<Character>priorityQueue=new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return hashMap.get(o2)-hashMap.get(o1);
            }
        });
        for(int i=0;i<s.length();i++){
            hashMap.put(s.charAt(i),hashMap.getOrDefault(s.charAt(i),0)+1);
        }
        List<String> candidates = new ArrayList(hashMap.keySet());


        List<String> candidates1 = new ArrayList(hashMap.keySet());
        Collections.sort(candidates1, (w1, w2) -> {
            if (hashMap.get(w1).equals(hashMap.get(w2)))
                return w1.compareTo(w2);
            return hashMap.get(w2) - hashMap.get(w1);
        });


        for(int i=0;i<s.length();i++){
            priorityQueue.add(s.charAt(i));
     
        }
        StringBuilder st=new StringBuilder();
        Iterator<Character>it=priorityQueue.iterator();
        while(it.hasNext()){
            st.append(it.next());
        }

        return st.toString();
    }

    @Override
    public int compareTo(StringSort o) {
        return 0;
    }
}
