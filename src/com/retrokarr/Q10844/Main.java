package com.retrokarr.Q10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] cache = new int[n + 1][10];
        Arrays.fill(cache[1], 1);

        for(int i = 2 ; i <= n ; ++i) {
           for(int j = 0 ; j < 10 ; ++j) {
               if(j == 0) {
                   cache[i][j] = cache[i - 1][1];
               } else if(j == 9) {
                   cache[i][j] = cache[i - 1][8];
               } else {
                   cache[i][j] = (cache[i - 1][j - 1] + cache[i - 1][j + 1]) % 1000000000;
               }
           }
        }

        int ret = 0;
        for(int i = 1 ; i < 10 ; ++i) {
            ret += cache[n][i];
            ret %= 1000000000;
        }

        System.out.println(ret);
    }
}
