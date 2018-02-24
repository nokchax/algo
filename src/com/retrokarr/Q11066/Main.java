package com.retrokarr.Q11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        FS sc = new FS();

        int testCase = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while(testCase-- > 0) {
            int num = sc.nextInt();
            int[] nums = new int[num];

            for(int i = 0 ; i < num ; ++i)
                nums[i] = sc.nextInt();

            sb.append(solve(nums)).append('\n');
        }

    }

    /*
    1, 2, 3, 4, ..., n-1, n

    n까지의 최소 합

    Math.min(2*(n + (n-1) + n-2까지의 최소), 2* (n + n-1까지의 최소))
    로 풀면 되지 않을까...?
     */
    static int solve(int[] nums) {

        return 1;
    }

    static class FS {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st = null;

        int nextInt() throws IOException {
            if(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());

            return Integer.parseInt(st.nextToken());
        }
    }
}
