package com.retrokarr.Q01158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int M = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);
        List<Integer> nums = new ArrayList<>();
        StringBuilder sb = new StringBuilder("<");

        for(int i = 1 ; i <= M ; ++i)
            nums.add(i);

        int target = 0;
        N--;

        while(!nums.isEmpty()) {
            target = (target + N) % nums.size();
            sb.append(nums.remove(target)).append(", ");
        }

        sb.replace(sb.length() - 2, sb.length(), ">");
        System.out.println(sb.toString());
    }
}
