package com.retrokarr.Q01516;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<Build> buildings;
    private static int[] cache;

    public static void main(String[] args) throws IOException {
        int numberOfBuildings = Integer.parseInt(br.readLine());
        buildings = new ArrayList<>(numberOfBuildings + 1);
        buildings.add(null);
        cache = new int[numberOfBuildings + 1];
        Arrays.fill(cache, -1);

        for(int i = 0 ; i < numberOfBuildings ; ++i)
            buildings.add(new Build());

        for(int i = 1 ; i <= numberOfBuildings ; ++i)
            bw.write(DFS(i) + "\n");

        bw.close();
    }

    private static int DFS(int start) {
        if(cache[start] > -1)
            return cache[start];

        Build building = buildings.get(start);
        int max = 0;

        for(int pre : building.getNeeds())
            max = Math.max(max, DFS(pre));

        return cache[start] = building.getCost() + max;
    }

    public static class Build {
        private int cost;
        private List<Integer> needs = new ArrayList<>();

        public Build() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost = Integer.parseInt(st.nextToken());
            int temp = 0;
            while(-1 != (temp = Integer.parseInt(st.nextToken())))
                needs.add(temp);
        }

        public int getCost() {
            return cost;
        }

        public List<Integer> getNeeds() {
            return needs;
        }
    }
}
