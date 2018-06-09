package com.retrokarr.Q11055;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cache = new int[size];
        int[] sequence = new int[size];

        for(int i = 0 ; i < size ; ++i)
            cache[i] = sequence[i] = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i < size ; ++i) {
            for(int j = 0 ; j < i ; ++j) {
                if(sequence[i] > sequence[j])
                    cache[i] = Math.max(cache[i], cache[j] + sequence[i]);
            }
        }

        int answer = 0;
        for(int i = 0 ; i < size ; ++i)
            answer = Math.max(answer, cache[i]);

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
