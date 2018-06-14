package com.retrokarr.Q13556;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Review2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int MOD = 5000000;
        int LIMIT = 100000;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] num = new int[N + 1];
        int[] cache = new int[N + 1];
        int[] visited = new int[LIMIT + 1];
        int[] bit = new int[LIMIT + 1];

        Arrays.fill(cache, 1);
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; ++i) {
            num[i] = Integer.parseInt(st.nextToken());
            visited[num[i]]++;
            if(visited[num[i]] > 1) cache[i] = 0;
        }

        for(int i = 2 ; i <= K ; ++i) {
            Arrays.fill(bit, 0);
            Arrays.fill(visited, 0);
            for(int j = 1 ; j <= N ; ++j) {
                for(int x = num[j] ; x <= LIMIT ; x += (x & -x))
                    bit[x] = (bit[x] + cache[j]) % MOD;
                cache[j] = (MOD - visited[num[j]]) % MOD;
                for(int x = num[j] - 1 ; x > 0 ; x -= (x & -x))
                    cache[j] = (bit[x] + cache[j]) % MOD;
                visited[num[j]] = (visited[num[j]] + cache[j]) % MOD;
            }
        }

        int answer = 0;
        for(int i = 1 ; i <= N ; ++i)
            answer = (answer + cache[i]) % MOD;

        bw.write(String.valueOf(answer));
        bw.close();
    }
}
