package com.retrokarr.Q10216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static FS sc = new FS();
    static int numOfCamp;
    static List<int[]> camp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int testCase = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while(testCase-- > 0) {
            camp = new ArrayList<>();
            numOfCamp = sc.nextInt();
            visited = new boolean[numOfCamp];
            int ret = 0;

            for(int i = 0 ; i < numOfCamp ; ++i) {
                int y = sc.nextInt();
                int x = sc.nextInt();
                int r = sc.nextInt();

                camp.add(new int[] {y, x, r});
            }

            for(int i = 0 ; i < numOfCamp ; ++i) {
                if(!visited[i]) {
                    DFS(i);
                    ret++;
                }
            }
            sb.append(ret).append('\n');
        }

        System.out.println(sb);
    }

    private static void DFS(int start) {
        for(int i = 0 ; i < numOfCamp ; ++i) {
            if(!visited[i] && isConnected(start, i)) {
                visited[i] = true;
                DFS(i);
            }
        }
    }

    private static boolean isConnected(int start, int i) {
        int[] startPoint = camp.get(start);
        int[] endPoint = camp.get(i);

        return Math.pow(startPoint[0] - endPoint[0], 2) + Math.pow(startPoint[1] - endPoint[1], 2) <= Math.pow(startPoint[2] + endPoint[2], 2);
    }

    static class FS {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int nextInt() throws IOException {
            if(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());

            return Integer.parseInt(st.nextToken());
        }
    }
}
