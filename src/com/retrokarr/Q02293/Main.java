package com.retrokarr.Q02293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int coin = Integer.parseInt(inputs[0]);
        int total = Integer.parseInt(inputs[1]);
        int[] cache = new int[total + 1];
        int[] coins = new int[coin];

        for(int i = 0 ; i < coin ; ++i)
            coins[i] = Integer.parseInt(br.readLine());

        cache[0] = 1;
        for(int targetCoin : coins) {
            for(int money = 1 ; money <= total ; ++money) {
                if(money < targetCoin)
                    continue;

                cache[money] += cache[money - targetCoin];
            }
        }

        System.out.println(cache[total]);
    }
}
