package com.retrokarr.Q01463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] cache = new int[x + 1];

        if(x > 0)
            cache[1] = 0;
        if(x > 1)
            cache[2] = 1;
        if(x > 2)
            cache[3] = 1;

        for(int i = 4 ; i <= x ; ++i) {
            int min = Integer.MAX_VALUE;
            if(i % 3 == 0)
                min = Math.min(min, cache[i / 3]);
            if(i % 2 == 0)
                min = Math.min(min, cache[i / 2]);

            min = Math.min(min, cache[i - 1]);

            cache[i] = min + 1;
        }

        System.out.println(cache[x]);
    }
}
