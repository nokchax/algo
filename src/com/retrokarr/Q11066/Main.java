package com.retrokarr.Q11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] cache;
    static int[] sum;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        FS sc = new FS();

        int testCase = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while(testCase-- > 0) {
            int num = sc.nextInt();
            nums = new int[num];
            cache = new int[num][num];
            sum = new int[num];
            int tempSum = 0;

            for(int i = 0 ; i < num ; ++i) {
                Arrays.fill(cache[i], -1);
                cache[i][i] = 0;
                nums[i] = sc.nextInt();
                tempSum += nums[i];
                sum[i] = tempSum;
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

        /**
         * for(int k = 0 , k < x ; ++k)
         *      Math.min(DFS(y, k) + DFS(k, x))
         */

        int min = Math.min(y, x);
        int max = Math.max(y, x);
        int temp = Integer.MAX_VALUE;
        for(int k = min ; k < max ; ++k) {
            int start = min > 0 ? sum[min] : 0;
            int target = DFS(y, k) + DFS(k + 1, x) + sum[max] - start;
            temp = Math.min(temp, target);
        }

        //sum에 대한 추가적인 dp..
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
