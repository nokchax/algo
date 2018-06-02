package com.retrokarr.Q01753;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nVertexs = Integer.parseInt(st.nextToken());
        int nEdges = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(br.readLine());
        int[] costs = new int[nVertexs + 1];
        Arrays.fill(costs, INF);
        ArrayList<NextVertex>[] edges = new ArrayList[nVertexs + 1];
        for(int i = 1 ; i <= nVertexs ; ++i)
            edges[i] = new ArrayList<>();

        while(nEdges-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[from].add(new NextVertex(to, weight));
        }

        PriorityQueue<NextVertex> pq = new PriorityQueue<>();
        pq.add(new NextVertex(startVertex, 0));
        costs[startVertex] = 0;

        while(!pq.isEmpty()) {
            NextVertex curVertex = pq.poll();
            ArrayList<NextVertex> nextVertexs = edges[curVertex.to];

            for(NextVertex nextVertex : nextVertexs) {
                if(costs[nextVertex.to] <= nextVertex.weight + costs[curVertex.to])
                    continue;

                costs[nextVertex.to] = nextVertex.weight + costs[curVertex.to];
                pq.add(new NextVertex(nextVertex.to, nextVertex.weight + costs[curVertex.to]));
            }
        }

        for(int i = 1 ; i <= nVertexs ; ++i)
            bw.write(costs[i] == INF ? "INF\n" : costs[i] + "\n");

        bw.close();
        br.close();
    }

    static class NextVertex implements Comparable<NextVertex> {
        int to;
        int weight;

        NextVertex(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(NextVertex o) {
            return this.weight - o.weight;
        }
    }
}
