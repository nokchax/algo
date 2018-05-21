package com.retrokarr.Q02606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//using floyd-warshall
public class Main {
    public static void main(String[] args) throws IOException {
        FS sc = new FS();
        int computer = sc.nextInt();
        int network = sc.nextInt();
        boolean[][] networks = new boolean[computer + 1][computer + 1];
        boolean[] infected = new boolean[computer + 1];

        for(int i = 0 ; i < network ; ++i) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            networks[to][from] = networks[from][to] = true;
        }
        infected[1] = true;

        for(int k = 1 ; k <= computer ; ++k)
            for(int i = 1 ; i <= computer ; ++i)
                for(int j = 1 ; j <= computer ; ++j)
                    if(infected[i] && (networks[i][j] || (networks[i][k] && networks[k][j])))
                        infected[j] = true;

        int ret = 0;
        for(int i = 2 ; i <= computer ; ++i)
            if(infected[i])
                ret++;

        System.out.println(ret);
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
