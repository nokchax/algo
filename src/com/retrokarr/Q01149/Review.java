package com.retrokarr.Q01149;

import java.io.*;
import java.util.StringTokenizer;

public class Review {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int nHouse = Integer.parseInt(br.readLine());
        int[][] cost = new int[nHouse][nHouse];
        int[][] cache = new int[nHouse][nHouse];
        for(int i = 0 ; i < nHouse ; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; ++j)
                cost[i][j] = Integer.parseInt(st.nextToken());
        }

        cache[0][0] = cost[0][0];
        cache[0][1] = cost[0][1];
        cache[0][2] = cost[0][2];

        for(int i = 1 ; i < nHouse ; ++i) {
            for(int j = 0 ; j < 3 ; ++j) {
                if(j == 1)
                    cache[i][j] = Math.min(cache[i - 1][j - 1], cache[i - 1][j + 1]);
                else
                    cache[i][j] = Math.min(cache[i - 1][1], j == 0 ? cache[i - 1][2] : cache[i - 1][0]);

                cache[i][j] += cost[i][j];
            }
        }

        int max = Math.min(cache[nHouse - 1][0], Math.min(cache[nHouse - 1][1], cache[nHouse - 1][2]));
        bw.write(String.valueOf(max));
        bw.close();
        br.close();
    }
}
