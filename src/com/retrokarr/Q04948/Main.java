package com.retrokarr.Q04948;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int limit = 123456 * 2;
        boolean[] isNotPrime = new boolean[limit + 1];
        isNotPrime[1] = true;

        for(int i = 2 ; i <= limit ; ++i)
            if(!isNotPrime[i])
                for(int j = i + i ; j <= limit ; j += i)
                    isNotPrime[j] = true;

        int n = 0;

        while( 0 != (n = Integer.parseInt(br.readLine()))) {
            int n2 = n * 2;

            int count = 0;
            for(int i = n + 1 ; i <= n2 ; ++i)
                if(!isNotPrime[i])
                    count++;

            bw.write(String.valueOf(count) + "\n");
        }

        bw.close();
        br.close();
    }
}
