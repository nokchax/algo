package com.retrokarr.Q13556;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Review {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int LIMIT = 100000;
    static int MOD = 5000000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] num = new int[N + 1];
        int[] cache = new int[N + 1];
        int[] bit = new int[LIMIT + 1];
        int[] visited = new int[LIMIT + 1];
        Arrays.fill(cache, 1);

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; ++i) {
            num[i] = Integer.parseInt(st.nextToken());
            visited[num[i]]++;
            if(visited[num[i]] > 1) cache[i] = 0;
        }

        for(int increasingSequenceLength = 2 ; increasingSequenceLength <= K ; ++increasingSequenceLength) {
            Arrays.fill(visited, 0);
            Arrays.fill(bit, 0);

            for(int idx = 1 ; idx <= N ; ++idx) {
                for(int x = num[idx] ; x <= LIMIT ; x += (x & -x))
                    bit[x] = (bit[x] + cache[idx]) % MOD;
                cache[idx] = (MOD - visited[num[idx]]) % MOD;
                for(int x = num[idx] - 1 ; x > 0 ; x -= (x & -x))
                    cache[idx] = (bit[x] + cache[idx]) % MOD;
                visited[num[idx]] = (visited[num[idx]] + cache[idx]) % MOD;
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
