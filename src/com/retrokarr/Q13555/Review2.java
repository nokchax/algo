package com.retrokarr.Q13555;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Review2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int MOD = 5000000;
    static int LIMIT = 100000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] num = new int[N + 1];
        int[] cache = new int[N + 1];
        int[] bit = new int[LIMIT + 1];
        Arrays.fill(cache, 1);

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; ++i)
            num[i] = Integer.parseInt(st.nextToken());

        for(int increasingSequenceLength = 2 ; increasingSequenceLength <= K ; ++increasingSequenceLength) {
            Arrays.fill(bit, 0);
            for(int idx = 1 ; idx <= N ; ++idx) {
                for(int x = num[idx] ; x <= LIMIT ; x += (x & -x))
                    bit[x] = (bit[x] + cache[idx]) % MOD;
                cache[idx] = 0;
                for(int x = num[idx] - 1 ; x > 0 ; x -= (x & -x))
                    cache[idx] = (bit[x] + cache[idx]) % MOD;
            }
        }

        int answer = 0;
        for(int i = 1 ; i <= N ; ++i)
            answer = (answer + cache[i]) % MOD;

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
