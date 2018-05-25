package com.retrokarr.Q09095;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        int[] cache = new int[11];
        cache[0] = 1;

        for(int i = 1 ; i < 11 ; ++i) {
            for(int j = 1 ; j < 4 ; ++j) {
                if(i < j)
                    continue;
                int before = i - j;
                cache[i] += cache[before];
            }
        }

        while(testCase-- > 0)
            bw.write(cache[Integer.parseInt(br.readLine())] + "\n");

        bw.close();
    }
}
