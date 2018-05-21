package com.retrokarr.Q02667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//using dfs
public class Main {
    static int[] mx = {1,-1, 0, 0};
    static int[] my = {0, 0, 1,-1};
    static int size;
    static String[] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        map = new String[size];

        for(int i = 0 ; i < size ; ++i)
            map[i] = br.readLine();

        visited = new boolean[size][size];
        List<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        for(int y = 0 ; y < size ; ++y) {
            for(int x = 0 ; x < size ; ++x){
                if(map[y].charAt(x) == '1' && !visited[y][x]) {
                    answer++;
                    list.add(DFS(y, x));
                }
            }
        }

        Collections.sort(list);
        for(int i : list)
            sb.append(i).append('\n');

        System.out.println(answer);
        System.out.println(sb.toString());
    }

    private static int DFS(int y, int x) {
        visited[y][x] = true;

        int ret = 1;
        for(int move = 0 ; move < mx.length ; ++move) {
            int nx = x + mx[move];
            int ny = y + my[move];

            if(nx < 0 || ny < 0 || nx == size || ny == size
                    || map[ny].charAt(nx) == '0'
                    || visited[ny][nx])
                continue;

            ret += DFS(ny, nx);
        }

        return ret;
    }
}
