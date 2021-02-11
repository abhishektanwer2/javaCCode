package com.extra;

import java.io.IOException;

public class priyaank {
    public static void main(String[] args) throws IOException {
        //InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        //BufferedReader in = new BufferedReader(reader);
        String line=";bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32";

//        while ((line = in.readLine()) != null) {
            String[] splittedInput = line.split(";");
            String pattern = splittedInput[0];
            String blobs = splittedInput[1];
            priyaank.doSomething(pattern, blobs);
//        }
    }

    public static void doSomething(String pattern, String blobs) {
        int sum = 0;

        String arrblobs[] = blobs.split("\\|");

        for (int i = 0; i < arrblobs.length; ++i) {

            int answer = 0, index = 0;

            for (;;) {

                if (!pattern .equals("")) {
                    int position = arrblobs[i].indexOf(pattern, index);
                    if (position < 0)
                        break;
                    answer++;
                    index = position + 1;
                }
                else{
                    break;
                }
            }

            System.out.print(answer + "|");

            sum = sum + answer;
        }

        System.out.println(sum);
    }
}
