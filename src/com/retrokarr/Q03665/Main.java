package com.retrokarr.Q03665;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0)
            bw.write(solve() + "\n");

        bw.close();
    }

    static String solve() throws IOException {
        int numOfTeam = Integer.parseInt(br.readLine());
        int[] team = new int[numOfTeam + 1];
        int[] in = new int[numOfTeam + 1];
        boolean[][] relation = new boolean[numOfTeam + 1][numOfTeam + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= numOfTeam ; ++i) {
            team[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= numOfTeam ; ++i)
            for(int j = i + 1 ; j <= numOfTeam ; ++j) {
                relation[team[i]][team[j]] = true;
                in[team[j]]++;
            }
        //end of init

        int data = Integer.parseInt(br.readLine());
        while(data-- > 0) {
            st = new StringTokenizer(br.readLine());
            int back = Integer.parseInt(st.nextToken());
            int fore = Integer.parseInt(st.nextToken());

            if(relation[back][fore]) {
                in[fore]--;
                in[back]++;
                relation[back][fore] = false;
                relation[fore][back] = true;
            } else {
                in[fore]++;
                in[back]--;
                relation[back][fore] = true;
                relation[fore][back] = false;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1 ; i <= numOfTeam ; ++i)
            if(in[i] == 0)
                q.add(i);

        StringBuilder sb = new StringBuilder();
        int answer = 1;
        for(int i = 1 ; i <= numOfTeam ; ++i) {
            if(q.isEmpty()) {
                answer = 0;
                break;
            }

            if(q.size() > 1) {
                answer = 2;
                break;
            }

            int curTeam = q.poll();
            sb.append(curTeam + " ");

            for(int j = 1 ; j <= numOfTeam ; ++j)
                if(relation[curTeam][j])
                    if(--in[j] == 0)
                        q.add(j);
        }

        switch (answer) {
            case 1:
                return sb.toString();
            case 2:
                return "?";
            case 0:
                return "IMPOSSIBLE";
        }

        return "";
    }
}
