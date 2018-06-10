package com.retrokarr.Q13555;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Review {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] cache = new int[N + 1];
        int[] num = new int[N + 1];
        int[] bit = new int[100001];
        int MOD = 5000000;

        Arrays.fill(cache, 1);
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; ++i)
            num[i] = Integer.parseInt(st.nextToken());

        for(int i = 2 ; i <= K ; ++i) {
            Arrays.fill(bit, 0);
            for(int j = 1 ; j <= N ; ++j) {
                for(int x = num[j] ; x <= 100000 ; x += (x & -x))
                    bit[x] = (bit[x] + cache[j]) % MOD;
                cache[j] = 0;
                for(int x = num[j] - 1 ; x > 0 ; x -= (x & -x))
                    cache[j] = (bit[x] + cache[j]) % MOD;
            }
        }

        int ans = 0;
        for(int i = 1 ; i <= N ; ++i)
            ans = (ans + cache[i]) % MOD;

        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }
}
