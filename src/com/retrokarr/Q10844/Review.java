package com.retrokarr.Q10844;

import java.io.*;
import java.util.Arrays;

public class Review {
    static int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] cache = new int[N + 1][10];
        Arrays.fill(cache[1], 1);
        br.close();

        for(int i = 2 ; i <= N ; ++i) {
            for(int j = 0 ; j < 9 ; ++j)
                cache[i][j] = (cache[i][j] + cache[i - 1][j + 1]) % MOD;
            for(int j = 1 ; j < 10 ; ++j)
                cache[i][j] = (cache[i][j] + cache[i - 1][j - 1]) % MOD;
        }

        int answer = 0;
        for(int i = 1 ; i < 10 ; ++i)
            answer = (cache[N][i] + answer) % MOD;

        bw.write(String.valueOf(answer));
        bw.close();
    }
}
