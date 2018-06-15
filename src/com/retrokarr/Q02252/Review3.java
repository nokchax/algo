package com.retrokarr.Q02252;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Review3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int nInfo = Integer.parseInt(st.nextToken());
        int[] in = new int[N + 1];
        ArrayList<Integer>[] relation = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; ++i)
            relation[i] = new ArrayList<>();

        for(int i = 0 ; i < nInfo ; ++i) {
            st = new StringTokenizer(br.readLine());
            int fore = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            relation[fore].add(back);
            ++in[back];
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= N ; ++i)
            if(in[i] == 0)
                q.add(i);

        while(!q.isEmpty()) {
            int cur = q.poll();
            bw.write(cur + " ");

            for(int next : relation[cur])
                if(--in[next] == 0)
                    q.add(next);
        }

        bw.close();
    }
}
