package com.retrokarr.Q01003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] zero = new int[41];
        int[] one = new int[41];

        zero[0] = 1;
        one[1] = 1;

        for(int i = 2 ; i < 41 ; ++i) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];
        }

        while(testCase-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(zero[num]).append(' ').append(one[num]).append('\n');
        }

        System.out.println(sb);
    }
}
