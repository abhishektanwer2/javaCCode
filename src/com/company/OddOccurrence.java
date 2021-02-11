package com.company;
import javax.sql.rowset.BaseRowSet;
import java.util.*;
import java.lang.*;

class OddOccurrence {
    static ArrayList<Integer>result=new ArrayList<>();
static Stack<String>input=new Stack<>();
    static Stack<String>copiedstring=new Stack<>();
    static Stack<String>deletedstring=new Stack<>();
    static Stack<String>pastestring=new Stack<>();
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        //int T = scanner.nextInt();
        //  for (int i = 0; i < T; i++) {
        // int N = scanner.nextInt();
        //int[] intArray = new int[N];
        //for (int j = 0; j < N; j++) {
        //  intArray[j] = scanner.nextInt();
        //}
      //  int[]intArray={1,2,1,2,3};
        //System.out.println(duplicate(intArray));
      /*  String []inputstring={"INSERT code","INSERT signal","Delete","UNDO","PASTE","COPY 2"};

        for(int i=0;i< inputstring.length;i++){
            String[]temp=inputstring[i].split(" ");
            switch(temp[0]){
                case "INSERT":insert(temp[1]);
                break;
                case "DELETE":delete();
                    break;
                case "UNDO":undo();
                break;
                case "PASTE":

                    paste();
                break;
                case "COPY":

                    copy(temp[1]);
                    break;


            }
            //stack to string
        }*/

        int[][]input=new int[][]{{5,3},{4,1},{2,4},{1,5},{3,2}};
        result.add(input[0][0]);
        result.add(input[0][1]);
        for(int i=1;i< input.length-1;i++) {
            result.add(recursive(input, result.get(result.size() - 1)));
        }
        System.out.println(result.toString());
    }


public static int recursive(int [][] input,int last){
    for(int i=1;i<input.length;i++){
        if(last==input[i][0] && !result.contains(input[i][1])){
            return input[i][1];
        }
        if(last==input[i][1] && !result.contains(input[i][0])){
return input[i][0];
        }
    }
    return -1;
}
    public static int duplicate(int[] arr) {
        int result=0;

        for(int i=0;i<arr.length;i++) {
            int counter = 0;
            HashMap<Integer,Integer>hash=new HashMap<>();
            for (int j = i;j< arr.length; j++)
            {
                if (hash.containsKey(arr[j])) {
                    hash.put(arr[j],hash.get(arr[j])+1);
                } else {
                    hash.put(arr[j], 1);
                }
                if (hash.get(arr[j]) == 2) {
                    counter++;
                }
                if(counter!=0&&counter==hash.size()){
                    result++;
                }
            }
        }
        return result;
    }

    public static void insert(String s){
input.push(s);
    }
    public static void delete(){
      String pop=  input.pop();
      pop=pop.substring(0,pop.length()-1);
      input.push(pop);
    }
    public static void copy(String s){}
    public static void paste(){
        String pop=   copiedstring.pop();
        String pop2=  input.pop();
        input.push(pop2+pop);
    }
    public static void undo(){

    }

    private static int getOddOccurrence(int[] intArray, int length) {
        int count = 0;
        String[] temp = new String[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            temp[i] = intArray[i] + "";
            int p = 0, countzero = 0;
            while (p < temp[i].length()) {

                if (temp[i].charAt(p) == '0') {
                    countzero++;


                }
                p++;
            }
            if (countzero % 2 != 0) {
                count++;
            }

        }

        return count;
    }

}



