package com.retrokarr.Q02504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static final String opening = "([", closing = ")]";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        String input = br.readLine();

        for(char target : input.toCharArray()) {
            if(opening.indexOf(target) != -1)
                stack.push(String.valueOf(target));
            else {
                if(stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                char top = stack.peek().charAt(0);
                if(opening.indexOf(top) != -1) {
                    if(opening.indexOf(top) == closing.indexOf(target)) {
                        stack.pop();
                        stack.push(String.valueOf(closing.indexOf(target) + 2));
                    } else {
                        System.out.println(0);
                        return;
                    }
                } else { //top is number
                    if(stack.isEmpty()) {
                        System.out.println(0);
                        return;
                    }

                    int temp = 0;
                    while(!stack.isEmpty() && opening.indexOf(stack.peek().charAt(0)) == -1) {
                        temp += Integer.parseInt(stack.pop());
                    }

                    if(stack.isEmpty() || opening.indexOf(stack.peek().charAt(0)) != closing.indexOf(target)) {
                        System.out.println(0);
                        return;
                    } else {
                        stack.pop();
                        if(temp == 0) temp = 1;
                        stack.push(String.valueOf(temp * (closing.indexOf(target) + 2)));
                    }
                }
            }
        }

        int answer = 0;
        while(!stack.isEmpty()) {
            if(opening.indexOf(stack.peek().charAt(0)) != -1) {
                System.out.println(0);
                return;
            }
            answer += Integer.parseInt(stack.pop());
        }

        System.out.println(answer);
    }
}
