package com.retrokarr.Q01912;

import java.io.*;
import java.util.StringTokenizer;

public class Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[N];
        int[] cache = new int[N];
        for(int i = 0 ; i < N ; ++i)
            num[i] = Integer.parseInt(st.nextToken());

        cache[0] = num[0];
        for(int i = 1 ; i < N ; ++i)
            cache[i] = cache[i - 1] < 0 ? num[i] : cache[i - 1] + num[i];

        int max = cache[0];
        for(int i = 0 ; i < N ; ++i)
            max = Math.max(max, cache[i]);

        bw.write(String.valueOf(max));
        bw.close();
    }
}
