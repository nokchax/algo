package com.retrokarr.Q01520;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Review2 {
    static int height, width;
    static int[][] heights, cache;
    static int[] mx = {1,-1, 0, 0};
    static int[] my = {0, 0, 1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        heights = new int[height][width];
        cache = new int[height][width];

        for(int i = 0 ; i < height ; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < width ; ++j)
                heights[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < height ; ++i)
            Arrays.fill(cache[i], -1);

        cache[0][0] = 1;
        bw.write(String.valueOf(DFS(height - 1, width - 1)));
        bw.close();
    }

    static int DFS(int y, int x) {
        if(cache[y][x] > -1)
            return cache[y][x];

        int sum = 0;
        for(int next = 0 ; next < mx.length ; ++next) {
            int nextY = y + my[next];
            int nextX = x + mx[next];
            if(nextY < 0 || nextX < 0 || nextX == width || nextY == height ||
                    heights[nextY][nextX] <= heights[y][x])
                continue;

            sum += DFS(nextY, nextX);
        }

        return cache[y][x] = sum;
    }
}
