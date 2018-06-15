package com.retrokarr.Q12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        Scan sc = new Scan();

        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0 ; i < n ; ++i)
            nums[i] = sc.nextInt();

        System.out.println(LIS(nums, nums.length));
    }

    static int CeilIndex(int[] nums, int l, int r, int key){
        while(r - l > 1){
            int m = l + (r - l)/2;

            if(nums[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    static int LIS(int[] nums, int size){
        int[] cache = new int[size];
        int len;

        len = 1;
        cache[0] = nums[0];

        for(int i = 1 ; i < size ; ++i){
            if(nums[i] < cache[0])
                cache[0] = nums[i];

            else if(nums[i] > cache[len-1])
                cache[len++] = nums[i];

            else
                cache[CeilIndex(cache, -1, len-1, nums[i])] = nums[i];
        }

        return len;
    }

    static class Scan{
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
        StringTokenizer st = null;

        int nextInt() throws IOException{
            if(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());

            return Integer.parseInt(st.nextToken());
        }
    }
}