package com.retrokarr.Q09012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(testcase-- > 0) {
            String input = br.readLine();
            sb.append(match(input)).append('\n');
        }

        System.out.println(sb.toString());
    }

    public static String match(String input) {
        int remain = 0;

        for(int i = 0 ; i < input.length() ; ++i) {
            char target = input.charAt(i);

            if(target == '(')
                remain++;
            else {
                if(remain == 0)
                    return "NO";

                remain--;
            }
        }

        return remain == 0 ? "YES" : "NO";
    }
}
