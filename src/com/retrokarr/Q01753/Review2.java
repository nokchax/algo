package com.retrokarr.Q01753;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Review2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int INF = 987654321;

        int nVertex = Integer.parseInt(st.nextToken());
        int nEdge = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(br.readLine());
        ArrayList<Vertex>[] vertexs = new ArrayList[nVertex + 1];
        int[] weights = new int[nVertex + 1];
        Arrays.fill(weights, INF);
        for(int i = 1 ; i <= nVertex ; ++i)
            vertexs[i] = new ArrayList<>();
        for(int i = 0 ; i < nEdge ; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            vertexs[from].add(new Vertex(to, weight));
        }

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(startVertex, 0));
        weights[startVertex] = 0;

        while(!pq.isEmpty()) {
            Vertex curVertex = pq.poll();
            if(curVertex.weight > weights[curVertex.no])
                continue;

            for(Vertex nextVertex : vertexs[curVertex.no]) {
                int nextWeight = curVertex.weight + nextVertex.weight;

                if(nextWeight < weights[nextVertex.no]) {
                    weights[nextVertex.no] = nextWeight;
                    pq.add(new Vertex(nextVertex.no, nextWeight));
                }
            }
        }

        for(int i = 1 ; i <= nVertex ; ++i)
            bw.write(weights[i] == INF ? "INF\n" : weights[i] + "\n");
        bw.close();
    }

    static class Vertex implements Comparable<Vertex> {
        int no;
        int weight;

        Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.weight - o.weight;
        }
    }
}
