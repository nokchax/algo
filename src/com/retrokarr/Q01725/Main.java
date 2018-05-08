package com.retrokarr.Q01725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> heights = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; ++i)
            heights.add(Integer.parseInt(br.readLine()));

        System.out.println(solve(heights));
    }

    private static int solve(List<Integer> heights) {
        int ret = 0;
        heights.add(0);
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < heights.size() ; ++i) {
            while(!stack.isEmpty() && heights.get(stack.peek()) >= heights.get(i)) {
                int j = stack.pop();
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);

                ret = Math.max(ret, width * heights.get(j));
            }
            stack.add(i);
        }

        return ret;
    }
}
