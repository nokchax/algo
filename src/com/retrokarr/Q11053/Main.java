package com.retrokarr.Q11053;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] cache = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; ++i)
            nums[i] = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; ++i)
            for(int j = 0 ; j < i ; ++j)
                if(nums[j] < nums[i])
                    cache[i] = Math.max(cache[i], cache[j] + 1);

        int max = -1;
        for(int i = 0 ; i < n ; ++i)
            max = Math.max(max, cache[i]);

        bw.write(String.valueOf(max + 1));
        bw.close();
        br.close();
    }
}
