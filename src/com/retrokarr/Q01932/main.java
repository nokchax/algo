package com.retrokarr.Q01932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] cache = new int[size][size];

        cache[0][0] = Integer.parseInt(br.readLine());
        for(int i = 1 ; i < size ; ++i) {
            String[] inputs = br.readLine().split(" ");

            for(int j = 0 ; j < inputs.length ; ++j) {


            }
        }
    }
}
