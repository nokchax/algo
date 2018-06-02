package com.retrokarr.Q02581;

import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        boolean[] isPrime = new boolean[10001];
        Arrays.fill(isPrime, true);

        isPrime[1] = false;
        for(int i = 2 ; i <= 10000 ; ++i) {
            if(isPrime[i]) {
                int limit = 10000 / i;
                for(int j = 2 ; j <= limit ; ++j)
                    isPrime[i * j] = false;
            }
        }

        int from = Integer.parseInt(br.readLine());
        int to = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = from ; i <= to ; ++i) {
            if(isPrime[i]) {
                sum += i;
                min = Math.min(min, i);
            }
        }

        if(sum == 0)
            bw.write("-1");
        else
            bw.write(String.valueOf(sum) + "\n" + String.valueOf(min));

        bw.close();
        br.close();
    }
}
