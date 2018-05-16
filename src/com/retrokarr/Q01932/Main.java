package com.retrokarr.Q01932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] cache = new int[size][size];

        cache[0][0] = Integer.parseInt(br.readLine());
        for(int i = 1 ; i < size ; ++i) {
            String[] inputs = br.readLine().split(" ");

            for(int j = 0 ; j < inputs.length ; ++j) {
                int value = Integer.parseInt(inputs[j]);
                int leftTop = j == 0 ? j : j - 1;
                int rightTop = j < inputs.length - 1 ? j : j - 1;

                cache[i][j] = value + Math.max(cache[i - 1][leftTop], cache[i - 1][rightTop]);
            }
        }

        int ret = 0;
        size--;
        for(int i = 0 ; i <= size ; ++i)
            ret = Math.max(ret, cache[size][i]);

        System.out.println(ret);
    }
}
