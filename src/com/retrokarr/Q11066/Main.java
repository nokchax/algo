package com.retrokarr.Q11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] cache;
    static int[][] totalSum;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        FS sc = new FS();

        int testCase = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while(testCase-- > 0) {
            int num = sc.nextInt();
            nums = new int[num];
            cache = new int[num][num];
            totalSum = new int[num][num];

            for(int i = 0 ; i < num ; ++i)
                cache[i][i] = nums[i] = sc.nextInt();

            sb.append(DFS(0, num - 1)).append('\n');

            for(int i = 0 ; i < num ; ++i) {
                for (int j = 0; j < num; ++j)
                    System.out.printf("%4d", totalSum[i][j]);
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
        System.out.println(y + ", " + x);
        if(cache[y][x] > 0)
            return cache[y][x];

        /**
         * for(int k = 0 , k < x ; ++k)
         *      Math.min(DFS(y, k) + DFS(k, x))
         */

        int min = Math.min(y, x);
        int max = Math.max(y, x);
        int temp = Integer.MAX_VALUE;
        int where = 0;
        for(int k = min ; k < max ; ++k) {
            int target = DFS(y, k) + DFS(k + 1, x);
            if(target <= temp) {
                temp = target;
                where = k;
            }
            //temp = Math.min(temp, DFS(y, k) + DFS(k + 1, x));
        }

        //sum에 대한 추가적인 dp..

        totalSum[y][x] = temp + totalSum[y][where] + totalSum[where + 1][x];
        return cache[y][x] = temp;
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
