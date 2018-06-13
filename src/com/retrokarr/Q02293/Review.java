package com.retrokarr.Q02293;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nCoin = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
        int[] coins = new int[nCoin];
        int[] cache = new int[cost + 1];

        for(int i = 0 ; i < nCoin ; ++i)
            coins[i] = Integer.parseInt(br.readLine());
        Arrays.sort(coins);
        cache[0] = 1;

        for(int coin : coins)
            for(int i = 1; i <= cost ; ++i)
                if(i >= coin)
                    cache[i] += cache[i - coin];

        bw.write(String.valueOf(cache[cost]));
        bw.close();
    }
}
