package com.retrokarr.Q13555;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] bit;
    static int[] cache;
    static int[] nums;
    static int n, k;
    static int MOD = 5000000;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new int[n + 1];
        cache = new int[n + 1];
        bit = new int[100002];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; ++i)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.fill(cache, 1);

        for(int i = 2 ; i <= k ; ++i) {
            for(int j = 1 ; j <= n ; ++j) {
                int temp = getSum(nums[j] - 1);
                update(nums[j], cache[j]);
                cache[j] = temp;
            }
            Arrays.fill(bit, 0);
        }

        int ans = 0;
        for(int i = 1 ; i <= n ; ++i)
            ans = (ans + cache[i]) % MOD;

        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }


    static int getSum(int idx) {
        int sum = 0;
        for(; idx > 0 ; idx -= idx & (-idx)) sum = (sum + bit[idx]) % MOD;
        return sum;
    }

    static void update(int idx, int value) {
        for(; idx <= 100001 ; idx += idx & (-idx)) bit[idx] = (bit[idx] + value) % MOD;
    }
}
/*        System.out.println("nums");
                for(int x : nums)
                System.out.printf("%3d", x);
                System.out.println();

                for(int i = 2 ; i <= k ; ++i) {
                for(int j = 1 ; j <= n ; ++j) {
                System.out.println("bit");
                for(int x = 0 ; x <= 10 ; ++x)
                System.out.printf("%3d", bit[x]);
                System.out.println();
                System.out.println("cache");
                for(int x : cache)
                System.out.printf("%3d", x);
                System.out.println();
                System.out.println();

                int t = getSum(nums[j] - 1);
                System.out.println("" + nums[j] + "까지의 합 : " + t);
                update(nums[j], cache[j]);
                cache[j] = t;

                System.out.println("bit");
                for(int x = 0 ; x <= 10 ; ++x)
                System.out.printf("%3d", bit[x]);
                System.out.println();
                System.out.println("cache");
                for(int x : cache)
                System.out.printf("%3d", x);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                }
                Arrays.fill(bit, 0);
                }

                int ans = 0;
                for(int i = 1 ; i <= n ; ++i)
                ans += cache[i];
                System.out.println(ans);
                }*/
