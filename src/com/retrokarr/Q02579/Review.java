package com.retrokarr.Q02579;

import java.io.*;

public class Review {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int nStep = Integer.parseInt(br.readLine());
        int[] score = new int[nStep + 1];
        int[] cache = new int[nStep + 1];

        for(int i = 1 ; i <= nStep ; ++i)
            score[i] = Integer.parseInt(br.readLine());

        cache[1] = score[1];
        if(nStep > 1)
            cache[2] = score[1] + score[2];

        for(int i = 3 ; i <= nStep ; ++i)
            cache[i] = Math.max(cache[i - 2] + score[i], cache[i - 3] + score[i] + score[i - 1]);

        bw.write(String.valueOf(cache[nStep]));
        bw.close();
        br.close();
    }
}
