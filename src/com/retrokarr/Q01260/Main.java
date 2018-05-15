package com.retrokarr.Q01260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static boolean[][] edges;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int vertex = Integer.parseInt(inputs[0]),
                edge = Integer.parseInt(inputs[1]),
                start = Integer.parseInt(inputs[2]);

        edges = new boolean[vertex + 1][vertex + 1];
        visited = new boolean[vertex + 1];

        for(int i = 0 ; i < edge ; ++i) {
            inputs = br.readLine().split(" ");
            int from = Integer.parseInt(inputs[0]),
                    to = Integer.parseInt(inputs[1]);

            edges[to][from] = edges[from][to] = true;
        }

        StringBuilder sb = new StringBuilder();
        DFS(start, sb);
        sb.append('\n');
        Arrays.fill(visited, false);
        BFS(start, sb);

        System.out.println(sb.toString());
    }

    private static void DFS(int start, StringBuilder sb) {
        if(visited[start])
            return;

        sb.append(start).append(' ');
        visited[start] = true;
        for(int i = 1 ; i < edges.length ; ++i)
            if(edges[start][i] && !visited[i])
                DFS(i, sb);
    }

    private static void BFS(int start, StringBuilder sb) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        sb.append(start).append(' ');
        q.add(start);

        while(!q.isEmpty()) {
            int here = q.poll();

            for(int i = 1 ; i < edges.length ; ++i) {
                if(!edges[here][i] || visited[i])
                    continue;

                q.add(i);
                sb.append(i).append(' ');
                visited[i] = true;
            }
        }
    }
}
