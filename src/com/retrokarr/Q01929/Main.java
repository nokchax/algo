package com.retrokarr.Q01929;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        boolean[] isNotPrime = new boolean[to + 1];
        isNotPrime[1] = true;

        for(int i = 2 ; i <= to ; ++i) {
            if(!isNotPrime[i]) {
                if(i >= from)
                    bw.write(String.valueOf(i) + "\n");

                for(int j = i + i ; j <= to ; j += i)
                    isNotPrime[j] = true;
            }
        }

        bw.close();
        br.close();
    }
}
