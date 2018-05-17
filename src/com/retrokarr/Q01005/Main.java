package com.retrokarr.Q01005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * StringTokenizer is faster than just user br.readLine().split(" "); then Integer.parse();
 */
public class Main {
    private static int numOfBuild;
    private static int numOfRule;
    private static int[] costs;
    private static boolean[][] rules;
    private static int[] cache;

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        int testCase = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while(testCase-- > 0) {
            numOfBuild = sc.nextInt();
            numOfRule = sc.nextInt();

            costs = new int[numOfBuild + 1];
            cache = new int[numOfBuild + 1];
            Arrays.fill(cache, -1);

            for(int i = 1 ; i <= numOfBuild ; ++i)
                costs[i] = sc.nextInt();

            rules = new boolean[numOfBuild + 1][numOfBuild + 1];
            for(int i = 0 ; i < numOfRule ; ++i) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                rules[from][to] = true;
            }

            sb.append(DFS(sc.nextInt())).append('\n');

        }

        System.out.println(sb.toString());
    }

    private static int DFS(int start) {
        if(cache[start] > -1)
            return cache[start];

        int max = 0;

        for(int i = 1 ; i <= numOfBuild ; ++i)
            if(rules[i][start])
                max = Math.max(max, DFS(i));

        return cache[start] = max + costs[start];
    }

    static class FastScanner {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;
        int nextInt() throws IOException {
            if(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}
