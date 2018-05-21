package com.retrokarr.Q07476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] mx = {1,-1, 0, 0};
    static int[] my = {0, 0, 1,-1};
    public static void main(String[] args) throws IOException {
        FS sc = new FS();

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] tomato = new int[M][N];

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < M ; ++i)
            for(int j = 0 ; j < N ; ++j) {
                tomato[i][j] = sc.nextInt();
                if(tomato[i][j] == 1)
                    q.add(new int[] {i, j});
            }

        while(!q.isEmpty()) {
            int cy = q.peek()[0];
            int cx = q.poll()[1];

            for(int move = 0 ; move < mx.length ; ++move) {
                int ny = cy + my[move];
                int nx = cx + mx[move];

                if(ny < 0 || nx < 0 || ny == M || nx == N || tomato[ny][nx] != 0)
                    continue;

                tomato[ny][nx] = tomato[cy][cx] + 1;
                q.add(new int[] {ny, nx});
            }
        }

        int max = 0;
        for(int i = 0 ; i < M ; ++i)
            for(int j = 0 ; j < N ; ++j) {
                if(tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, tomato[i][j]);
            }

        System.out.println(max - 1);
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

