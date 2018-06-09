package com.retrokarr.Q11054;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        int[] sequence = new int[size];
        int[] forwardCache = new int[size];
        int[] reverseCache = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < size ; ++i)
            sequence[i] = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i < size ; ++i)
            for(int j = i - 1 ; j >= 0 ; --j)
                if(sequence[i] > sequence[j])
                    forwardCache[i] = Math.max(forwardCache[i], forwardCache[j] + 1);

        for(int i = size - 2 ; i >= 0 ; --i)
            for(int j = i + 1 ; j < size ; ++j)
                if(sequence[i] > sequence[j])
                    reverseCache[i] = Math.max(reverseCache[i], reverseCache[j] + 1);

        int answer = 0;
        for(int i = 0 ; i < size ; ++i)
            answer = Math.max(answer, forwardCache[i] + reverseCache[i]);

        bw.write(String.valueOf(answer + 1));
        bw.close();
        br.close();
    }
}
