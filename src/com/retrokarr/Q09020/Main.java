package com.retrokarr.Q09020;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        boolean[] isNotPrime = new boolean[10000 + 1];
        isNotPrime[1] = true;
        for(int i = 2 ; i <= 10000 ; ++i)
            if(!isNotPrime[i])
                for(int j = i + i ; j <= 10000 ; j += i)
                    isNotPrime[j] = true;

        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0) {
            int left = 0, right = 0;
            int target = Integer.parseInt(br.readLine());

            for(int temp = target / 2 ; temp > 1 ; --temp) {
                if(!isNotPrime[temp] && !isNotPrime[target - temp]) {
                    left = temp;
                    right = target - temp;
                    break;
                }
            }

            bw.write(String.valueOf(left) + " " + String.valueOf(right) + "\n");
        }

        bw.close();
        br.close();
    }
}
