package com.retrokarr.Q01149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfHouse = Integer.parseInt(br.readLine());
        int[][] cost = new int[numOfHouse][3];
        int[][] cache = new int[numOfHouse][3];

        for(int i = 0 ; i < numOfHouse ; ++i) {
            String[] inputs = br.readLine().split(" ");

            for(int j = 0 ; j < 3 ; ++j)
                cost[i][j] = Integer.parseInt(inputs[j]);
        }
        cache[0][0] = cost[0][0];
        cache[0][1] = cost[0][1];
        cache[0][2] = cost[0][2];
        for(int i = 1 ; i < numOfHouse ; ++i) {
            for(int j = 0 ; j < 3; ++j) {
                int left = j < 1 ? 2 : j - 1;
                int right = j > 1 ? 0 : j + 1;

                cache[i][j] = cost[i][j] + Math.min(cache[i - 1][left], cache[i - 1][right]);
            }
        }

        System.out.println(Math.min(cache[numOfHouse - 1][0],
                Math.min(cache[numOfHouse - 1][1], cache[numOfHouse - 1][2])
        ));
    }
}
