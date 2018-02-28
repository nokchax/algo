package com.retrokarr.Q11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] cache;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        FS sc = new FS();

        int testCase = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while(testCase-- > 0) {
            int num = sc.nextInt();
            nums = new int[num];
            cache = new int[num][num];

            for(int i = 0 ; i < num ; ++i) {
                nums[i] = sc.nextInt();
                Arrays.fill(cache[i], -1);
                cache[i][i] = nums[i];
            }

            sb.append(DFS(0, num - 1)).append('\n');

            for(int i = 0 ; i < num ; ++i) {
                for (int j = 0; j < num; ++j)
                    System.out.printf("%4d", cache[i][j]);
                System.out.println();
            }
        }
        System.out.println(sb);
    }

    /*
    연쇄 행렬 곱셈 알고리즘
    matrix chain multiplication
     */
    static int DFS(int y, int x) {
        if(cache[y][x] > -1)
            return cache[y][x];

        if(y == x)
            return cache[y][x] = nums[y];

        return cache[y][x] = Math.min(2 * DFS(y, x - 1) + nums[x], 2 * DFS(y + 1, x) + nums[nums.length - 1 - y]);
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
