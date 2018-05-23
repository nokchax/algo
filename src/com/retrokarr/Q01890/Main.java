package com.retrokarr.Q01890;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static long[][] cache;
    static int size, goal;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        FS sc = new FS();

        size = sc.nextInt();
        goal = size - 1;

        map = new int[size][size];
        cache = new long[size][size];

        for(int i = 0 ; i < size ; ++i) {
            for(int j = 0 ; j < size ; ++j)
                map[i][j] = sc.nextInt();
            Arrays.fill(cache[i], -1L);
        }

        if(map[0][0] != 0)
            cache[0][0] = 1L;

        bw.write(String.valueOf(DFS(goal, goal)));
        bw.flush();
        bw.close();
    }

    public static long DFS(int y, int x) {
        if(cache[y][x] > -1)
            return cache[y][x];

        long curAnswer = 0L;
        for(int i = 1 ; i < 10 ; ++i) {
            if(y < i)
                break;

            if(map[y - i][x] == i)
                curAnswer += DFS(y - i, x);
        }

        for(int i = 1 ; i < 10 ; ++i) {
            if(x < i)
                break;

            if(map[y][x - i] == i)
                curAnswer += DFS(y, x - i);
        }

        cache[y][x] = curAnswer;
        return cache[y][x];
    }

    public static class FS {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int nextInt() throws IOException {
            if(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());

            return Integer.parseInt(st.nextToken());
        }
    }
}
