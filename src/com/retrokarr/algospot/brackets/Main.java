package com.retrokarr.algospot.brackets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String opening = "({[", closing = ")}]";

    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(testcase-- > 0)
            sb.append(solve(br.readLine())).append('\n');

        System.out.println(sb.toString());
    }

    private static String solve(String brackets) {
        Stack<Character> remains = new Stack<>();

        for(char target : brackets.toCharArray()) {
            if(opening.indexOf(target) != -1)
                remains.push(target);
            else {
                if(remains.isEmpty()) return "NO";
                if(opening.indexOf(remains.pop()) != closing.indexOf(target)) return "NO";
            }
        }

        return remains.isEmpty() ? "YES" : "NO";
    }
}
