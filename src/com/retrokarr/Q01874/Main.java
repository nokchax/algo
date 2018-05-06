package com.retrokarr.Q01874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            int target = Integer.parseInt(br.readLine());

            if(stack.isEmpty() || stack.peek() < target) {
                while(num < target) {
                    stack.push(++num);
                    sb.append('+').append('\n');
                }
            }

            if(stack.peek() == target){
                stack.pop();
                sb.append('-').append('\n');
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb.toString());
    }
}
