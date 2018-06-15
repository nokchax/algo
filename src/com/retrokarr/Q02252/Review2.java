package com.retrokarr.Q02252;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Review2 {
    static int N, nInfo;
    static boolean[] visited;
    static ArrayList<Integer>[] relation;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nInfo = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        relation = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; ++i)
            relation[i] = new ArrayList<>();

        for(int i = 0 ; i < nInfo ; ++i) {
            st = new StringTokenizer(br.readLine());
            int fore = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            relation[fore].add(back);
        }

        for(int i = 1 ; i <= N ; ++i)
            if(!visited[i])
                DFS(i);

        while(!stack.isEmpty())
            bw.write(stack.pop() + " ");
        bw.close();
    }

    static void DFS(int cur) {
        visited[cur] = true;

        for(int next : relation[cur])
            if(!visited[next])
                DFS(next);

        stack.add(cur);
    }
}
