package com.retrokarr.Q11726;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] cache = new int[n + 1];
        cache[0] = cache[1] = 1;

        for(int i = 2 ; i <= n ; ++i)
            cache[i] = (cache[i - 1] + cache[i - 2]) % 10007;

        bw.write(String.valueOf(cache[n]));
        bw.close();
    }
}
