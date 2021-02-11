package practiseother;

import java.util.regex.Matcher;

public class RemoveVowel {
public static void main(String[]args){
    String inputString="abhishek is my nameA ";
    String removedvowelstring=findandRemoveVowel(inputString);
    System.out.println(removedvowelstring);
}

    private static String findandRemoveVowel(String inputString) {

    StringBuilder result=new StringBuilder();
        String matchString = "[^aeiou]+$";
    for(int i=0;i<inputString.length();i++){
        if(Character.toLowerCase(inputString.charAt(i))!= 'a'&&Character.toLowerCase(inputString.charAt(i))!= 'e'&&Character.toLowerCase(inputString.charAt(i))!= 'i'&&Character.toLowerCase(inputString.charAt(i))!= 'o'&&Character.toLowerCase(inputString.charAt(i))!= 'u'){
            result.append(inputString.charAt(i));
        }

    }

    return result.toString();
    }
}
