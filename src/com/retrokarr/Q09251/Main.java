package com.retrokarr.Q09251;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int[][] lcs = new int[a.length + 1][b.length + 1];

        for(int i = 1 ; i <= a.length ; ++i) {
            for(int j = 1 ; j <= b.length ; ++j) {
                if(a[i - 1] == b[j - 1])
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }

        bw.write(String.valueOf(lcs[a.length][b.length]));
        bw.close();
        br.close();
    }
}
