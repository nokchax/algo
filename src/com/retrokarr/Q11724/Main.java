package com.retrokarr.Q11724;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;
    static ArrayList<Integer>[] vertexs;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());

        vertexs = new ArrayList[vertex + 1];
        for(int i = 1 ; i <= vertex ; ++i)
            vertexs[i] = new ArrayList<>();

        for(int i = 0 ; i < edges ; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            vertexs[from].add(to);
            vertexs[to].add(from);
        }

        visited = new boolean[vertex + 1];
        int ret = 0;

        for(int i = 1 ; i <= vertex ; ++i) {
            if(!visited[i]) {
                DFS(i);
                ret++;
            }
        }

        bw.write(String.valueOf(ret));
        bw.close();
        br.close();
    }

    static void DFS(int start) {
        visited[start] = true;

        ArrayList<Integer> nextVertex = vertexs[start];
        for(int next : nextVertex)
            if(!visited[next])
                DFS(next);
    }
}
