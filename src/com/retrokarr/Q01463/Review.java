package com.retrokarr.Q01463;

import java.io.*;

public class Review {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(br.readLine());
        int[] cache = new int[x + 1];

        for(int i = 2 ; i <= x ; ++i) {
            cache[i] = cache[i - 1];

            if(i % 2 == 0)
                cache[i] = Math.min(cache[i], cache[i / 2]);
            if(i % 3 == 0)
                cache[i] = Math.min(cache[i], cache[i / 3]);
            cache[i]++;
        }

        bw.write(String.valueOf(cache[x]));
        bw.close();
        br.close();
    }
}
