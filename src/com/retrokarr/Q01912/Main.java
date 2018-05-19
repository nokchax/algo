package com.retrokarr.Q01912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] nums = new int[count];
        int temp = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < count ; ++i)
            nums[i] = Integer.parseInt(st.nextToken());

        int max = nums[0];
        for(int i = 0 ; i < count ; ++i) {
            temp += nums[i];
            max = Math.max(max, temp);

            if(temp < 0)
                temp = 0;
        }

        System.out.println(max);
    }
}
