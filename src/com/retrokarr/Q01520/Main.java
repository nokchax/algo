package com.retrokarr.Q01520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int[] mx = {1, 0, -1, 0};
    private static final int[] my = {0, -1, 0, 1};
    private static int[][] map;
    private static int[][] cache;
    private static int m, n;

    public static void main(String[] args) throws IOException {
        FS sc = new FS();

        m = sc.nextInt();
        n = sc.nextInt();

        map = new int[m][n];
        cache = new int[m][n];

        for(int i = 0 ; i < m ; ++i)
            for(int j = 0 ; j < n ; ++j)
                map[i][j] = sc.nextInt();

        for(int i = 0 ; i < m ; ++i)
            Arrays.fill(cache[i], -1);

        cache[0][0] = 1;

        System.out.println(BFS(n-1, m-1));
    }

    static int BFS(int x, int y) {
        if(cache[y][x] > -1)
            return cache[y][x];

        cache[y][x] = 0;

        for(int i = 0 ; i < mx.length ; ++i) {
            int nextx = x + mx[i];
            int nexty = y + my[i];

            if(nextx < 0 || nexty < 0 || nextx >= n || nexty >= m)
                continue;

            if (map[y][x] < map[y + my[i]][x + mx[i]])
                cache[y][x] += BFS(x + mx[i], y + my[i]);
        }

        return cache[y][x];
    }

    static class FS {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st = null;

        int nextInt() throws IOException {
            if(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());

            return Integer.parseInt(st.nextToken());
        }
    }
}
