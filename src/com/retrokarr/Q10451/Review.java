package com.retrokarr.Q10451;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//using dfs
public class Review {
    static int[] to;
    static boolean[] visited;
    static FS sc = new FS();
    public static void main(String[] args) throws IOException {

        int testCase = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while(testCase-- > 0)
            sb.append(solve()).append('\n');

        System.out.println(sb);
    }

    private static int solve() throws IOException {
        int vertex = sc.nextInt();
        to = new int[vertex + 1];
        visited = new boolean[vertex + 1];

        for(int i = 1 ; i <= vertex ; ++i)
            to[i] = sc.nextInt();

        int answer = 0;
        for(int i = 1 ; i <= vertex ; ++i)
            if(!visited[i] && DFS(i, to[i]))
                answer++;

        return answer;
    }

    private static boolean DFS(int start, int by) {
        visited[by] = true;

        return start == by || DFS(start, to[by]);
    }

    public static class FS {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int nextInt() throws IOException {
            if(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());

            return Integer.parseInt(st.nextToken());
        }
    }
}
