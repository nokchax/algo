package com.retrokarr.Q02156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfGlass = Integer.parseInt(br.readLine());
        int[] grapes = new int[numOfGlass];
        int[] cache = new int[numOfGlass];

        for(int i = 0 ; i < numOfGlass ; ++i)
            grapes[i] = Integer.parseInt(br.readLine());

        if(numOfGlass > 0)
            cache[0] = grapes[0];
        if(numOfGlass > 1)
            cache[1] = grapes[0] + grapes[1];
        if(numOfGlass > 2)
            cache[2] = Math.max(grapes[0] + grapes[1], (grapes[2] + Math.max(grapes[0], grapes[1])));

        for(int i = 3 ; i < numOfGlass ; ++i)
            cache[i] = Math.max(cache[i - 1], grapes[i] + Math.max(cache[i - 2], cache[i - 3] + grapes[i - 1]));

        System.out.println(cache[numOfGlass - 1]);
    }
}
