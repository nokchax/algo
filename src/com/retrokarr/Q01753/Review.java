package com.retrokarr.Q01753;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Review {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int nVertexs, nEdges, start;
    static int costs[];
    static ArrayList<Vertex>[] vertexs;

    static class Vertex implements Comparable<Vertex> {
        int no;
        int cost;

        Vertex(int no, int cost) {
            this.no = no;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.cost - o.cost;
        }
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        nVertexs = Integer.parseInt(st.nextToken());
        nEdges = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        costs = new int[nVertexs + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        vertexs = new ArrayList[nVertexs + 1];
        for(int i = 1 ; i <= nVertexs ; ++i)
            vertexs[i] = new ArrayList<>();

        while(nEdges-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            vertexs[from].add(new Vertex(to, cost));
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(start, 0));
        costs[start] = 0;

        while(!pq.isEmpty()) {
            int curVertex = pq.peek().no;
            int cost = pq.poll().cost;

            if(costs[curVertex] < cost)
                continue;

            for(Vertex next : vertexs[curVertex]) {
                int nextNo = next.no;
                int nextCost = cost + next.cost;

                if(costs[nextNo] > nextCost) {
                    costs[nextNo] = nextCost;
                    pq.add(new Vertex(nextNo, nextCost));
                }
            }
        }

        for(int i = 1 ; i <= nVertexs ; ++i)
            bw.write(costs[i] == Integer.MAX_VALUE ? "INF\n" : String.valueOf(costs[i]) + "\n");

        bw.close();
        br.close();
    }
}
