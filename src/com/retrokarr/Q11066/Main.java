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
    연쇄 행렬 곱셈 알고리즘
    matrix chain multiplication
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
