package com.retrokarr.Q11047;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nCoins = Integer.parseInt(st.nextToken());
        int won = Integer.parseInt(st.nextToken());

        int[] coins = new int[nCoins];
        for(int i = 0 ; i < nCoins ; ++i)
            coins[i] = Integer.parseInt(br.readLine());

        int coin = nCoins - 1;
        int totalCoins = 0;
        while(won > 0) {
            while(coins[coin] > won) {
                coin--;
            }

            totalCoins += won / coins[coin];
            won %= coins[coin];
        }

        bw.write(String.valueOf(totalCoins));
        bw.close();
        br.close();
    }
}
