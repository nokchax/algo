package com.retrokarr.Q13555;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Review3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int MOD = 5000000;
        int LIMIT = 100000;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] bit = new int[LIMIT + 1];
        int[] num = new int[N + 1];
        int[] cache = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; ++i)
            num[i] = Integer.parseInt(st.nextToken());
        Arrays.fill(cache, 1);

        for(int i = 2 ; i <= K ; ++i) {
            Arrays.fill(bit, 0);
            for(int j = 1 ; j <= N ; ++j) {
                for(int x = num[j] ; x <= LIMIT ; x += (x & -x))
                    bit[x] = (bit[x] + cache[j]) % MOD;
                cache[j] = 0;
                for(int x = num[j] - 1 ; x > 0 ; x -= (x & -x))
                    cache[j] = (bit[x] + cache[j]) % MOD;
            }
        }

        int answer = 0;
        for(int i = 1 ; i <= N ; ++i)
            answer = (answer + cache[i]) % MOD;

        bw.write(String.valueOf(answer));
        bw.close();
    }
}
