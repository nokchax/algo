package com.retrokarr.Q02252;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static List<List<Integer>> relation;
    private static int students;
    private static int relations;
    private static boolean[] visited;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        students = Integer.parseInt(st.nextToken());
        relations = Integer.parseInt(st.nextToken());
        visited = new boolean[students + 1];

        relation = new ArrayList<>(students + 1);
        for(int i = 0 ; i <= students ; ++i)
            relation.add(new ArrayList<>());

        for(int i = 0 ; i < relations ; ++i) {
            st = new StringTokenizer(br.readLine());
            relation.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 1 ; i <= students ; ++i)
            if(!visited[i])
                DFS(i);

        while(!stack.isEmpty())
            bw.write(stack.pop() + " ");

        bw.close();
    }

    private static void DFS(int start) {
        visited[start] = true;
        List<Integer> curRelation = relation.get(start);

        for(int next : curRelation)
            if(!visited[next])
                DFS(next);

        stack.add(start);
    }
}
