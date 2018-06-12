package com.retrokarr.Q01260;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Review {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int nVertex, nEdge, startVertex;
    static boolean[] visited;
    static ArrayList<Integer>[] vertex;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        nVertex = Integer.parseInt(st.nextToken());
        nEdge = Integer.parseInt(st.nextToken());
        startVertex = Integer.parseInt(st.nextToken());
        visited = new boolean[nVertex + 1];

        vertex = new ArrayList[nVertex + 1];
        for(int i = 1 ; i <= nVertex ; ++i)
            vertex[i] = new ArrayList<>();

        for(int i = 0 ; i < nEdge ; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            vertex[from].add(to);
            vertex[to].add(from);
        }
        for(int i = 1 ; i <= nVertex ; ++i)
            Collections.sort(vertex[i]);

        bw.write(DFS());
        Arrays.fill(visited, false);
        bw.write(BFS());
        bw.close();
        br.close();
    }

    static String DFS() {
        StringBuilder sb = new StringBuilder();
        DFSALL(startVertex, sb);
        return sb.append('\n').toString();
    }

    static void DFSALL(int curVertexNo, StringBuilder sb) {
        visited[curVertexNo] = true;
        sb.append(curVertexNo + " ");
        for(int nextVertex : vertex[curVertexNo]) {
            if(visited[nextVertex]) continue;

            DFSALL(nextVertex, sb);
        }
    }

    static String BFS() {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.add(startVertex);
        sb.append(startVertex + " ");
        visited[startVertex] = true;
        while(!q.isEmpty()) {
            int curVertexNo = q.poll();
            ArrayList<Integer> curVertex = vertex[curVertexNo];

            for(int nextVertex : curVertex) {
                if(visited[nextVertex]) continue;

                visited[nextVertex] = true;
                q.add(nextVertex);
                sb.append(nextVertex + " ");
            }
        }

        return sb.toString();
    }
}
