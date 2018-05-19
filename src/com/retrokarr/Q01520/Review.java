package com.retrokarr.Q01520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Review {
    private static int M, N;
    private static int[][] height;
    private static int[][] cache;
    private static int[] mx = {1, -1, 0, 0};
    private static int[] my = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        FS sc = new FS();
        M = sc.nextInt();
        N = sc.nextInt();
        height = new int[M][N];
        cache = new int[M][N];

        for(int y = 0 ; y < M ; ++y) {
            for(int x = 0; x < N; ++x)
                height[y][x] = sc.nextInt();
            Arrays.fill(cache[y], -1);
        }

        cache[0][0] = 1;

        System.out.println(solve(M - 1, N - 1));
    }

    private static int solve(int y, int x) {
        if(cache[y][x] > -1)
            return cache[y][x];

        int sum = 0;
        for(int i = 0 ; i < mx.length ; ++i) {
            int nextX = x + mx[i];
            int nextY = y + my[i];

            if(nextX < 0 || nextY < 0 || nextX == N || nextY == M || height[y][x] >= height[nextY][nextX])
                continue;

            sum += solve(nextY, nextX);
        }

        return cache[y][x] = sum;
    }

    public static class FS {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st = null;

        public int nextInt() throws IOException {
            if(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());

            return Integer.parseInt(st.nextToken());
        }
    }
}
