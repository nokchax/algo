package com.retrokarr.Q10451;

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
            int[] nums = new int[num + 1];

            for(int i = 1 ; i < nums.length ; ++i)
                nums[i] = sc.nextInt();

            sb.append(solve(nums)).append('\n');
        }

        System.out.println(sb);
    }

    private static int solve(int[] nums) {
        int ret = 0;
        boolean[] visited = new boolean[nums.length];

        for(int i = 1 ; i < nums.length ; ++i) {

            int start = i;
            int next = nums[i];
            visited[i] = true;

            while(!visited[next]) {
                visited[next] = true;
                next = nums[next];
            }

            if(start == next)
                ret++;
        }

        return ret;
    }

    static class FS {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st = null;

        int nextInt() throws IOException {
            if(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());

            return Integer.parseInt(st.nextToken());
        }

    }
}
