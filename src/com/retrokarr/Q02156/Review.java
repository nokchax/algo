package com.retrokarr.Q02156;

import java.io.*;

public class Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nGrape = Integer.parseInt(br.readLine());
        int[] grape = new int[nGrape + 1];
        int[] cache = new int[nGrape + 1];
        for(int i = 1 ; i <= nGrape ; ++i)
            grape[i] = Integer.parseInt(br.readLine());

        if(nGrape > 0)
            cache[1] = grape[1];
        if(nGrape > 1)
            cache[2] = grape[1] + grape[2];

        for(int i = 3 ; i <= nGrape ; ++i)
            cache[i] = Math.max(cache[i - 1], Math.max(grape[i - 1] + cache[i - 3], cache[i - 2]) + grape[i]);

        bw.write(String.valueOf(cache[nGrape]));
        bw.close();
    }
}
