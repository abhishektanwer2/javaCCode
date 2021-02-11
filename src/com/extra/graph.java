package com.extra;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class graph {
    ArrayList<Integer>result=new ArrayList<>() ;
    static int[]countlist;
    static HashSet<Integer>visited=new HashSet<>();
    public static void main(String []args){
    int n=3;
        HashMap<String, List<String>>matrix=new HashMap<>()
;    int [][]red={{0,1}};
    int [][]blue={{2,1}};
  countlist=new int[n];
  Arrays.fill(countlist,-1);
  countlist[0]=0;



    trervresebfs(red,n,matrix,blue);
    }

    private static void trervresebfs(int[][] red, int n, HashMap<String, List<String>> matrix, int[][] blue) {
        ArrayList<String>list=new ArrayList<>();
        ArrayList<String>list2=new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>>graph=new HashMap<>();
        list.add("red");
        list2.add("blue");

        for(int i=0;i<red.length;i++){

           //matrix.put(red[i][0]+","+red[i][1],list);


            if(matrix.containsKey(red[i][0]+","+red[i][1])){
                List<String>list1=matrix.get(red[i][0]+","+red[i][1]);
                list1.add("red");
                matrix.put(red[i][0]+","+red[i][1],list1);
                //com.extra.graph.put(red[i][0],list1);
            }
            else{
                List<String>list1=new ArrayList<>();
                list1.add("red");
                matrix.put(red[i][0]+","+red[i][1],list1);
            }


          if(graph.containsKey(red[i][0])){
              ArrayList<Integer>list1=graph.get(red[i][0]);
              list1.add(red[i][1]);
              graph.put(red[i][0],list1);
          }
          else{
              ArrayList<Integer>list1=new ArrayList<>();
              list1.add(red[i][1]);
              graph.put(red[i][0],list1);
          }



            }
        for(int i=0;i<blue.length;i++){

            if(matrix.containsKey(blue[i][0]+","+blue[i][1])){
                List<String>list1=matrix.get(blue[i][0]+","+blue[i][1]);
                list1.add("blue");
                matrix.put(blue[i][0]+","+blue[i][1],list1);
                //com.extra.graph.put(red[i][0],list1);
            }
            else{
                List<String>list1=new ArrayList<>();
                list1.add("blue");
                matrix.put(blue[i][0]+","+blue[i][1],list1);
            }
            if(graph.containsKey(blue[i][0])){
                ArrayList<Integer>list1=graph.get(blue[i][0]);
                list1.add(blue[i][1]);
                graph.put(blue[i][0],list1);
            }
            else{
                ArrayList<Integer>list1=new ArrayList<>();
                list1.add(blue[i][1]);
                graph.put(blue[i][0],list1);
            }



        }
        Stack<ArrayList<Integer>>adjacent=new Stack<>();
        dfs(0,"",graph,matrix,0);
        for (int i : countlist) {
            System.out.println(i);
        }

        }

    private static void dfs(int i, String s, HashMap<Integer, ArrayList<Integer>> graph, HashMap<String, List<String>> matrix, int count) {
        if(visited.contains(i))return;
        visited.add(i);
       ArrayList<Integer>baseelement=graph.get(i);
       if(baseelement==null)return;
        for(int k=0;k<baseelement.size();k++)
        {
            if(visited.contains(baseelement.get(k)))continue;
            if(matrix.containsKey(i+","+baseelement.get(k))){
                String color="";
                List<String> colorlist= matrix.get(i+","+baseelement.get(k));
                if(s=="red"){
                    if(colorlist.contains("blue")){
                        color="blue";
                        colorlist.remove("blue");
                    }else{return;}
                }else if(s=="blue"){
                    if(colorlist.contains("red")){
                       color="red";
                        colorlist.remove("red");

                    }else return;}
                    else{
                        color=matrix.get(i+","+baseelement.get(k)).get(0);
                    }
              //  matrix.replace(i+","+baseelement.get(k),new ArrayList<>());
                if(!s.equals(color)){
                    countlist[baseelement.get(k)]=count+1;
                    dfs(baseelement.get(k),color,graph,matrix, count++);
                }
                else {return;}

            }
        }
    }


}



