package practiseother;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Practise {
  static Map<Integer,Integer> memo=new HashMap<Integer,Integer>();

  public static int  numDecoding(String s) {
      //return recursiveSolutionwithmemo(0,s);
     // return iterativeSolutionwithdp(s);
      return iterativeSolutionwith2var(s);
  }

    private static int iterativeSolutionwith2var(String s) {
      int onedigit=1;
      int twodigit=1;


      for(int i=1;i<s.length();i++){
          int sum=0;
          if(s.charAt(i-1)!='0')
          {sum=onedigit;}

      int  twoback=Integer.parseInt(s.substring(i-1,i+1));
        if(twoback>=10&&twodigit<=26){
            sum+=twodigit;
        }
        twodigit=onedigit;
        onedigit=sum;

      }
      return onedigit;

    }

    private static int iterativeSolutionwithdp(String s) {
      int[]dp=new int[s.length()+1];
      dp[0]=1;
      dp[1]=s.charAt(0)=='0'?0:1;
      for(int i=2;i<=s.length();i++){
          if(s.charAt(i-1)!='0'){
              dp[i]=dp[i-1];
          }
          int digit2=Integer.parseInt(s.substring(i-2,i));
          if(digit2>=10&&digit2<=26){
              dp[i]+=dp[i-2];
          }

      }
      return dp[s.length()];

    }

    public static int recursiveSolutionwithmemo(int i, String s) {
      if(memo.containsKey(i))return memo.get(i);
      if(i==s.length())return 1;
      if(s.charAt(i)=='0')return 0;
      if(i==s.length()-1)return 1;

      int answer=recursiveSolutionwithmemo(i+1,s);
      if(Integer.parseInt(s.substring(i,i+2))<=26){
          answer+=recursiveSolutionwithmemo(i+2,s);
      }
      memo.put(i,answer);
      return answer;

    }
    public static void main(String []args){
      String s="2126";
      System.out.println(numDecoding(s));
    }
}
