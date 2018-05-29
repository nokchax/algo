package com.retrokarr.Q01516;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//using q
public class Review {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int numOfBuilding = Integer.parseInt(st.nextToken());
        int[] in = new int[numOfBuilding + 1];
        int[] cost = new int[numOfBuilding + 1];
        ArrayList<Integer>[] previousBuildings = new ArrayList[numOfBuilding + 1];
        ArrayList<Integer>[] nextBuildings = new ArrayList[numOfBuilding + 1];
        for(int i = 1 ; i <= numOfBuilding ; ++i) {
            previousBuildings[i] = new ArrayList<>();
            nextBuildings[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= numOfBuilding ; ++i) {
            st = new StringTokenizer(br.readLine());
            int curCost = Integer.parseInt(st.nextToken());
            int prev = 0;
            cost[i] = curCost;

            while((prev = Integer.parseInt(st.nextToken())) > -1) {
                previousBuildings[i].add(prev);
                nextBuildings[prev].add(i);
                in[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= numOfBuilding ; ++i)
            if(in[i] == 0)
                q.add(i);

        while(!q.isEmpty()) {
            int curBuilding = q.poll();
            int maxPrevCost = 0;

            for(int prev : previousBuildings[curBuilding])
                maxPrevCost = Math.max(maxPrevCost, cost[prev]);

            for(int next : nextBuildings[curBuilding])
                if(--in[next] == 0)
                    q.add(next);

            cost[curBuilding] += maxPrevCost;
        }

        for(int i = 1 ; i <= numOfBuilding ; ++i)
            bw.write(cost[i] + "\n");

        bw.close();
    }
}
