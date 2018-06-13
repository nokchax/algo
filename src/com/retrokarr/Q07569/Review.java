package com.retrokarr.Q07569;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int depth = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int[] mx = {1,-1, 0, 0, 0, 0};
        int[] my = {0, 0, 1,-1, 0, 0};
        int[] mh = {0, 0, 0, 0, 1,-1};

        int[][][] tomato = new int[height][depth][width];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < height ; ++i)
            for(int j = 0 ; j < depth ; ++j) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < width ; ++k) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomato[i][j][k] == 1)
                        q.add(new int[]{i, j, k});
                }
            }

        while(!q.isEmpty()) {
            int ch = q.peek()[0];
            int cy = q.peek()[1];
            int cx = q.poll()[2];

            for(int i = 0 ; i < mx.length ; ++i) {
                int nh = ch + mh[i];
                int ny = cy + my[i];
                int nx = cx + mx[i];

                if(ny < 0 || nh < 0 || nx < 0 || ny == depth || nh == height || nx == width || tomato[nh][ny][nx] == -1
                        || tomato[nh][ny][nx] != 0) continue;

                q.add(new int[] {nh, ny, nx});
                tomato[nh][ny][nx] = tomato[ch][cy][cx] + 1;
            }
        }

        int max = 0;
        for(int i = 0 ; i < height ; ++i) {
            for (int j = 0 ; j < depth ; ++j) {
                for (int k = 0 ; k < width ; ++k) {
                    if(tomato[i][j][k] == 0) {
                        bw.write("-1");
                        bw.close();
                        return;
                    }
                    max = Math.max(max, tomato[i][j][k]);
                }
            }
        }

        bw.write(String.valueOf(max - 1));
        bw.close();
    }
}
