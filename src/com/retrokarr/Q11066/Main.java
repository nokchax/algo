package com.retrokarr.Q11066;

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

    static String solve() throws IOException {
        int nChapters = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sum = new int[nChapters + 1];
        int[][] cache = new int[nChapters + 1][nChapters + 1];

        for(int i = 1 ; i <= nChapters ; ++i)
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

        for(int i = 2 ; i <= nChapters ; ++i) {
            for(int j = i - 1 ; j > 0 ; --j) {
                cache[j][i] = 987654321;
                for(int k = j ; k < i ; ++k)
                    cache[j][i] = Math.min(cache[j][i], cache[j][k] + cache[k + 1][i]);

                cache[j][i] += sum[i] - sum[j - 1];
            }
        }

        return String.valueOf(cache[1][nChapters]);
    }
}
