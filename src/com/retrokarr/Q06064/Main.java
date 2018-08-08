package com.retrokarr.Q06064;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0)
            bw.write(solve() + "\n");

        bw.close();
        br.close();
    }

    private static String solve() throws  IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int lcm = getLCM(M, N);
        int value = 0;

        while(value + x <= lcm) {
            if((value + x - y) % N == 0)
                return String.valueOf(value + x);

            value += M;
        }

        return "-1";
    }

    private static int getLCM(int m, int n) {
        return m * n / getGCD(m, n);
    }

    private static int getGCD(int m, int n) {
        while(n != 0) {
            int remain = m % n;
            m = n;
            n = remain;
        }

        return m;
    }
}
