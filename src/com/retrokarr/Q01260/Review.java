package com.retrokarr.Q01260;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Review {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nVertex = Integer.parseInt(st.nextToken());
        int nEdge = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] vertex = new ArrayList[nVertex + 1];
        for(int i = 1 ; i <= nVertex ; ++i)
            vertex[i] = new ArrayList<>();


    }
}
