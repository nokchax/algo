package com.retrokarr.Q02252;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//use queue
public class Review {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfStudent = Integer.parseInt(st.nextToken());
        int numOfRelation = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] students = new ArrayList[numOfStudent + 1];
        int[] in = new int[numOfStudent + 1];
        for(int i = 1 ; i <= numOfStudent ; ++i)
            students[i] = new ArrayList<>();

        for(int i = 0 ; i < numOfRelation ; ++i) {
            st = new StringTokenizer(br.readLine());
            int fore = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            students[fore].add(back);
            in[back]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= numOfStudent ; ++i)
            if(in[i] == 0)
                q.add(i);

        while(!q.isEmpty()) {
            int curStudent = q.poll();
            bw.write(curStudent + " ");

            for(int next : students[curStudent])
                if(--in[next] == 0)
                    q.add(next);
        }

        bw.close();
    }
}
