package com.retrokarr.Q01005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Review {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K, goalBuilding;
    static int[] cost, cache;
    static ArrayList<Integer>[] edge;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cost = new int[N + 1];
            cache = new int[N + 1];
            edge = new ArrayList[N + 1];

            Arrays.fill(cache, -1);
            st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i <= N ; ++i) {
                edge[i] = new ArrayList<>();
                cost[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0 ; i < K ; ++i) {
                st = new StringTokenizer(br.readLine());
                int need = Integer.parseInt(st.nextToken());
                int build = Integer.parseInt(st.nextToken());

                edge[build].add(need);
            }

            goalBuilding = Integer.parseInt(br.readLine());

            bw.write(solve(goalBuilding) + "\n");
        }
        bw.close();
        br.close();
    }

    static int solve(int curBuild) {
        if(cache[curBuild] > -1)
            return cache[curBuild];

        int max = 0;
        for(int needBuilding : edge[curBuild])
            max = Math.max(max, solve(needBuilding));

        return cache[curBuild] = cost[curBuild] + max;
    }
}
