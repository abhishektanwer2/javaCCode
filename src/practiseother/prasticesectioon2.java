package practiseother;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class prasticesectioon2 {
    public static void main(String []args){
   int arr[]={};

   int constraint=160;
   String input="Paragraphs are the building blocks of papers."+
           "paragraph.";
   List<String> output=new ArrayList<>();
int numberofsegment=(input.length()/constraint)+1;
        StringBuilder temp=new StringBuilder();
   System.out.println(numberofsegment);
   int countword=0;
   int j=1;
   for(int i=0;i<input.length();i++){

       if(countword<=160 &&i<input.length()-1){
           temp.append(input.charAt(i));
           countword++;
       }
       else{
           temp.append(" "+j+"/"+numberofsegment);
           output.add(temp.toString());
           countword=0;
           temp.setLength(0);
           j++;
       }
   }
        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }
}
