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
        ArrayList<Integer>[] nextTeam = new ArrayList[numOfTeam + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= numOfTeam ; ++i) {
            nextTeam[i] = new ArrayList<>();
            team[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= numOfTeam ; ++i)
            for(int j = i + 1 ; j <= numOfTeam ; ++j) {
                nextTeam[team[i]].add(team[j]);
                in[team[j]]++;
            }
        //end of init

        boolean impossible = false;
        int data = Integer.parseInt(br.readLine());
        while(data-- > 0) {
            st = new StringTokenizer(br.readLine());
            int back = Integer.parseInt(st.nextToken());
            int fore = Integer.parseInt(st.nextToken());

            if(!nextTeam[fore].contains(back))
                impossible = true;
            else
                nextTeam[fore].remove(nextTeam[fore].indexOf(back));

            if(--in[back] < 0)
                impossible = true;

            nextTeam[back].add(fore);
            in[fore]++;
        }

        if(impossible)
            return "IMPOSSIBLE";

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= numOfTeam ; ++i)
            if(in[i] == 0) {
                if(q.isEmpty())
                    q.add(i);
                else
                    return "?";
            }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int curTeam = q.poll();
            sb.append(curTeam + " ");

            for(int next : nextTeam[curTeam]) {
                if(--in[next] == 0)
                    q.add(next);

                if(in[next] < 0)
                    return "IMPOSSIBLE";
            }
        }

        for(int i = 1 ; i <= numOfTeam ; ++i)
            if(in[i] != 0)
                return "IMPOSSIBLE";

        return sb.toString();
    }
}
