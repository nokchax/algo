package com.retrokarr.Q02294;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nCoin = Integer.parseInt(st.nextToken());
        int totalCost = Integer.parseInt(st.nextToken());
        int[] cache = new int[totalCost + 1];
        int[] coins = new int[nCoin];

        for(int i = 0 ; i < nCoin ; ++i)
            coins[i] = Integer.parseInt(br.readLine());
        Arrays.fill(cache, Integer.MAX_VALUE);

        cache[0] = 0;
        for(int i = 1 ; i <= totalCost ; ++i)
            for(int coin : coins)
                if(i >= coin && cache[i - coin] != Integer.MAX_VALUE)
                    cache[i] = Math.min(cache[i], cache[i - coin] + 1);

        bw.write(String.valueOf(cache[totalCost] == Integer.MAX_VALUE ? -1 : cache[totalCost]));
        bw.close();
    }
}
