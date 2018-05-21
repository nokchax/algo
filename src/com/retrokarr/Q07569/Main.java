package com.retrokarr.Q07569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] mh = {0, 0, 0, 0, 1,-1};
    static int[] my = {1,-1, 0, 0, 0, 0};
    static int[] mx = {0, 0, 1,-1, 0, 0};
    public static void main(String[] args) throws IOException {
        FS sc = new FS();

        int width = sc.nextInt();
        int depth = sc.nextInt();
        int height = sc.nextInt();
        int[][][] tomatos = new int[height][depth][width];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < height ; ++i)
            for(int j = 0 ; j < depth ; ++j)
                for(int k = 0 ; k < width ; ++k) {
                    tomatos[i][j][k] = sc.nextInt();
                    if(tomatos[i][j][k] == 1)
                        q.add(new int[] {i, j, k});
                }

        while(!q.isEmpty()) {
            int ch = q.peek()[0];
            int cy = q.peek()[1];
            int cx = q.poll()[2];

            for(int move = 0 ; move < mh.length ; ++move) {
                int nh = ch + mh[move];
                int nx = cx + mx[move];
                int ny = cy + my[move];

                if(nh < 0 || nx < 0 || ny < 0 ||
                        nh == height || nx == width || ny == depth || tomatos[nh][ny][nx] != 0)
                    continue;

                tomatos[nh][ny][nx] = tomatos[ch][cy][cx] + 1;
                q.add(new int[] {nh, ny, nx});
            }
        }


        int ret = 0;
        for(int i = 0 ; i < height ; ++i)
            for(int j = 0 ; j < depth ; ++j)
                for(int k = 0 ; k < width ; ++k) {
                    if(tomatos[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    ret = Math.max(ret, tomatos[i][j][k]);
                }

        System.out.println(ret - 1);
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
