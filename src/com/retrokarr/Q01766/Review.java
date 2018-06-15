package com.retrokarr.Q01766;

import java.io.*;
import java.util.*;

public class Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int nReliation = Integer.parseInt(st.nextToken());
        int[] in = new int[N + 1];
        ArrayList<Integer>[] problem = new ArrayList[N + 1];

        for(int i = 1 ; i <= N ; ++i)
            problem[i] = new ArrayList<>();

        for(int i = 0 ; i < nReliation ; ++i) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int post = Integer.parseInt(st.nextToken());

            problem[pre].add(post);
            ++in[post];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1 ; i <= N ; ++i)
            if(in[i] == 0)
                pq.add(i);

        while(!pq.isEmpty()) {
            int curProblem = pq.poll();
            bw.write(curProblem + " ");

            for(int nextProblem : problem[curProblem])
                if(--in[nextProblem] == 0)
                    pq.add(nextProblem);
        }

        bw.close();
    }
}
