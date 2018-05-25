package com.retrokarr.Q01325;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int computers;
    static List<List<Integer>> hasFaiths;
    public static void main(String[] args) throws IOException {
        FS sc = new FS();

        computers = sc.nextInt();
        int relations = sc.nextInt();
        hasFaiths = new ArrayList<>(computers + 1);
        for(int i = 0 ; i <= computers ; ++i)
            hasFaiths.add(new ArrayList<>());

        for(int i = 0 ; i < relations ; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            hasFaiths.get(b).add(a);
        }

        int max = -1;

        List<Integer> ret = new ArrayList<>();
        for(int i = 1 ; i <= computers ; ++i) {
            visited = new boolean[computers + 1];
            visited[i] = true;
            int numOfHackableCom = count(i);

            if(max == numOfHackableCom) {
                ret.add(i);
            } else if(max < numOfHackableCom) {
                ret.clear();
                ret.add(i);
                max = numOfHackableCom;
            }
        }

        Collections.sort(ret);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < ret.size() ; ++i)
            sb.append(ret.get(i)).append(' ');

        System.out.println(sb);
    }

    static int count(int start) {
        int ret = 1;
        List<Integer> cur = hasFaiths.get(start);

        for(int i = 0; i < cur.size() ; ++i) {
            int next = cur.get(i);
            if(!visited[next]) {
                visited[next] = true;
                ret += count(next);
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
