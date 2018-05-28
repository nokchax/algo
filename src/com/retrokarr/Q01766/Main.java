package com.retrokarr.Q01766;

import java.io.*;
import java.util.*;

//use priority queue
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int questions = Integer.parseInt(st.nextToken());
        int numberOfRelation = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] relations = new ArrayList[questions + 1];
        int[] in = new int[questions + 1];

        for(int i = 1 ; i <= questions ; ++i)
            relations[i] = new ArrayList<>();

        for(int i = 0 ; i < numberOfRelation ; ++i) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            relations[prev].add(next);
            in[next]++;
        }

        for(int i = 1 ; i <= questions ; ++i)
            if(in[i] == 0)
                pq.add(i);

        while(!pq.isEmpty()) {
            int curQuestion = pq.poll();
            bw.write(curQuestion + " ");

            for(int next : relations[curQuestion])
                if(--in[next] == 0)
                    pq.add(next);
        }

        bw.close();
    }
}
