package com.retrokarr.Q01978;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        boolean[] isPrime = new boolean[1001];
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for(int i = 2 ; i <= 1000 ; ++i) {
            if(isPrime[i]) {

                int limit = 1000 / i;
                for(int x = 2 ; x <= limit ; ++x)
                    isPrime[i * x] = false;
            }
        }

        int answer = 0;
        while(st.hasMoreTokens()) {
            if(isPrime[Integer.parseInt(st.nextToken())])
                answer++;
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
