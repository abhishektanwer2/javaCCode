package practiseother;

import java.util.HashMap;

public class AuthnticateToken {

    public static void main(String []args){
        int [][]commands=new int [][]{{0,1,1},{0,2,2},{1,1,5},{1,2,7}};
        System.out.println(numOfActiveToken(commands));

    }


    public static int  numOfActiveToken(int[][] commands){
        int expirytime=4;
        HashMap<Integer,Integer>tokens=new HashMap<>();
        for(int i=0;i<commands.length;i++){

                if((commands[i][0])==1){
                    if(tokens.containsKey(commands[i][1])){
                   if(tokens.get(commands[i][1])<commands[i][2]){
                       tokens.remove(commands[i][1]);
                   }
                   else{
                       tokens.replace(commands[i][1],tokens.get(commands[i][1])+expirytime);
                   }
                }
            }else{
                tokens.put(commands[i][1],commands[i][2]+expirytime);
            }
        }
        return tokens.size();
    }
}
