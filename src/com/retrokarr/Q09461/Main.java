package com.retrokarr.Q09461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        long[] cache = new long[101];

        cache[1] = cache[2] = cache[3] = 1L;
        cache[4] = 2L;

        for(int i = 5 ; i < 101 ; ++i)
            cache[i] = cache[i - 1] + cache[i - 5];

        StringBuilder sb = new StringBuilder();
        while(testCase-- > 0)
            sb.append(cache[Integer.parseInt(br.readLine())]).append('\n');

        System.out.println(sb.toString());
    }
}
