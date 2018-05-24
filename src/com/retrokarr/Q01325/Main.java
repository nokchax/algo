package com.retrokarr.Q01325;

import java.io.*;
import java.util.*;

//왜지
public class Main {
    static boolean[] visited;
    static boolean[][] hackable;
    static int vertex, relations;
    public static void main(String[] args) throws IOException {
        FS sc = new FS();
        vertex = sc.nextInt();
        relations = sc.nextInt();
        hackable = new boolean[vertex + 1][vertex + 1];

        for(int i = 0 ; i < relations ; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            hackable[b][a] = true;
        }

        List<Integer> ret = new ArrayList<>();
        int max = -1;

        for(int i = 1 ; i <= vertex ; ++i) {
            visited = new boolean[vertex + 1];

            int totalHackableCom = DFS(i);

            if(ret.isEmpty()) {
                ret.add(i);
                max = totalHackableCom;
            } else {
                if(totalHackableCom < max)
                    continue;
                if(totalHackableCom > max) {
                    ret.clear();
                    max = totalHackableCom;
                }
                ret.add(i);
            }
        }

        Collections.sort(ret);
        StringBuilder sb = new StringBuilder();
        for(int i : ret)
            sb.append(i).append(' ');

        System.out.println(sb.toString());
    }

    private static int DFS(int target) {
        visited[target] = true;
        int ret = 1;

        for(int i = 1 ; i <= vertex ; ++i) {
            if(hackable[target][i] && !visited[target]) {
                ret += DFS(i);
            }
        }

        return ret;
    }

    public static class FS {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st = null;

        int nextInt() throws IOException {
            if(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());

            return Integer.parseInt(st.nextToken());
        }
    }
}
