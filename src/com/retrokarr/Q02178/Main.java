package com.retrokarr.Q02178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] mx = {1,-1, 0, 0};
    static int[] my = {0, 0, 1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int height = Integer.parseInt(inputs[0]);
        int width = Integer.parseInt(inputs[1]);

        String[] map = new String[height];
        boolean[][] visited = new boolean[height][width];

        for(int i = 0 ; i < height ; ++i)
            map[i] = br.readLine();

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int cy = q.peek()[0];
            int cx = q.peek()[1];
            int count = q.poll()[2];

            if(cy == height - 1 && cx == width -1) {
                System.out.println(count);
                return;
            }

            for(int move = 0 ; move < mx.length ; ++move) {
                int ny = cy + my[move];
                int nx = cx + mx[move];

                if(ny < 0 || nx < 0 || ny == height || nx == width
                        || visited[ny][nx]
                        || map[ny].charAt(nx) == '0')
                    continue;

                visited[ny][nx] = true;
                q.add(new int[]{ny, nx, count +1});
            }
        }
    }
}
