package com.retrokarr.Q10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ; ++i) {
            String cmd = br.readLine();
            String[] inputs = cmd.split(" ");

            switch(inputs[0]) {
                case "push":
                    stack.push(Integer.parseInt(inputs[1]));
                    break;

                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
                    break;

                case "size":
                    sb.append(stack.size()).append('\n');
                    break;

                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append('\n');
                    break;

                case "pop":
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
