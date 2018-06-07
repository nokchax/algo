package com.retrokarr.Q01254;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        for(int i = str.length() ; ; ++i) {
            boolean isPelindrome = true;

            for(int j = 0 ; j < str.length() ; ++j) {
                if(i - j - 1 < str.length() && str.charAt(j) != str.charAt(i - j - 1)) {
                    isPelindrome = false;
                    break;
                }
            }

            if(isPelindrome) {
                bw.write(String.valueOf(i));
                break;
            }
        }

        bw.close();
        br.close();
    }
}
