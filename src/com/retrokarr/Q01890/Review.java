package com.retrokarr.Q01890;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Review {
    static int N;
    static int[][] map;
    static long[][] way;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        way = new long[N][N];
        for(int i = 0 ; i < N ; ++i)
            Arrays.fill(way[i], -1L);

        way[N - 1][N - 1] = 1L;
        for(int i = 0 ; i < N ; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(String.valueOf(DFS(0, 0)));
        bw.close();
    }

    static long DFS(int y, int x) {
        if(way[y][x] > -1) return way[y][x];

        way[y][x] = 0L;
        if(y + map[y][x] < N)
            way[y][x] += DFS(y + map[y][x], x);
        if(x + map[y][x] < N)
            way[y][x] += DFS(y, x + map[y][x]);

        return way[y][x];
    }
}
