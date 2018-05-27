package com.retrokarr.Q01766;

import java.io.*;
import java.util.*;

//can't pass
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<List<Integer>> relations;
    static Stack<Integer> stack = new Stack<>();
    static boolean[] solved;
    static int questions;
    static int numberOfRelation;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        questions = Integer.parseInt(st.nextToken());
        numberOfRelation = Integer.parseInt(st.nextToken());
        solved = new boolean[questions + 1];
        relations = new ArrayList<>(questions + 1);
        relations.add(null);
        for(int i = 1 ; i <= questions ; ++i)
            relations.add(new ArrayList<>());

        for(int i = 0 ; i < numberOfRelation ; ++i) {
            st = new StringTokenizer(br.readLine());
            relations.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 1 ; i <= questions ; ++i)
            Collections.sort(relations.get(i), Collections.reverseOrder());

        for(int i = questions ; i > 0 ; --i)
            if(!solved[i])
                DFS(i);

        while(!stack.isEmpty())
            bw.write(stack.pop() + " ");

        bw.close();
    }

    private static void DFS(int start) {
        solved[start] = true;
        List<Integer> relation = relations.get(start);

        for(int next : relation)
            if(!solved[next])
                DFS(next);

        stack.push(start);
    }
}
