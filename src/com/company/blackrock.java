package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class blackrock {
    public static void main(String[] args) {

        String input = "Vodafone,Stock,10|Google,Stock,15:Vodafone,Stock,15|Microsoft,Stock,2|Google,Stock,10";
        String[] inputarr = input.split(":");
        Map<String, String> portfolio = new HashMap<>();
        Map<String, String> benchmark = new HashMap<>();
        String[] snew = inputarr[0].split("\\|");
        String[] snew2 = inputarr[1].split("\\|");


        for (int i = 0; i < snew.length; i++) {
            String[] m = snew[i].split(",");
            portfolio.put(m[0] + "," + m[1], m[2]);
        }

        for (int i = 0; i < snew2.length; i++) {
            String[] m = snew2[i].split(",");
            benchmark.put(m[0] + "," + m[1], m[2]);
        }

            System.out.println(mactchbenchmark(benchmark, portfolio));

    }

    private static ArrayList<String> mactchbenchmark(Map<String, String> benchmark, Map<String, String> portfolio) {
        ArrayList<String>resultaarray=new ArrayList<>();
        String result="";

        for (Map.Entry<String, String> s : benchmark.entrySet()) {
            if (portfolio.containsKey(s.getKey())) {
                int pval = Integer.parseInt(portfolio.get(s.getKey()));
                int bval = Integer.parseInt(benchmark.get(s.getKey()));

                if (pval - bval > 0) {
                    int t = pval - bval;
                    result = " Buy," + s.getKey() + "," + t;
                    resultaarray.add(result);
                }
                else {
                    int t = Math.abs(pval - bval);
                    result = " Sell," + s.getKey() + "," + t;
                    resultaarray.add(result);
                }

            } else
                {
                if
                (benchmark.containsKey(s.getKey())) {
                    result = " Buy," + s.getKey() + "," + benchmark.get(s.getKey());
                    resultaarray.add(result);
                }

            }
        }

        for (Map.Entry<String, String> s : portfolio.entrySet()) {
            {
                if (!benchmark.containsKey(s.getKey())) {
                    result = " Sell " + s.getKey() + "," + portfolio.get(s.getKey());
                    resultaarray.add(result);
                }
            }

            resultaarray.sort((o1, o2) -> {
                String[] out1=o1.split(",");
                String[] out2=o2.split(",");
                if(out1[1].charAt(0)<out2[1].charAt(0)){
                    return 1;
                }else if(out1[1].charAt(0)>out2[1].charAt(0)){
                    return -1;
                }else{
                    if(out1[2].charAt(0)<out2[2].charAt(0)){
                        return 1;
                    }
                }
                return 0;
            });



        }

        return resultaarray;
    }


}
