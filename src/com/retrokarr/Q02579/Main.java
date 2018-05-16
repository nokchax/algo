package com.retrokarr.Q02579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stairs = Integer.parseInt(br.readLine());
        int[] scores = new int[stairs];
        int[] cache = new int[stairs];

        for(int i = 0 ; i < stairs ; ++i)
            scores[i] = Integer.parseInt(br.readLine());

        if(stairs > 0)
            cache[0] = scores[0];
        if(stairs > 1)
            cache[1] = scores[0] + scores[1];
        if(stairs > 2)
            cache[2] = scores[2] + Math.max(scores[0], scores[1]);

        for(int i = 3 ; i < stairs ; ++i)
            cache[i] = Math.max(scores[i - 1] + cache[i - 3], cache[i - 2]) + scores[i];

        System.out.println(cache[stairs - 1]);
    }
}
