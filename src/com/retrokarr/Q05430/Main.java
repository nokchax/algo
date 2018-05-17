package com.retrokarr.Q05430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0)
            sb.append(solve()).append('\n');

        System.out.println(sb.toString());
    }


    private static String solve() throws IOException {
        Deque<String> deque = new LinkedList<>();
        boolean isFront = true;
        String cmds = br.readLine();
        int num = Integer.parseInt(br.readLine());
        String nums = br.readLine();
        if(nums.length() > 2)
            nums = nums.substring(1, nums.length() - 1);
        else
            nums = "";

        if(! nums.isEmpty()) {
            String[] inputs = nums.split(",");

            for (String input : inputs)
                deque.addLast(input);
        }

        for(char cmd : cmds.toCharArray()) {
            switch(cmd) {
                case 'R':
                    isFront = !isFront;
                    break;
                case 'D':
                    if(deque.isEmpty())
                        return "error";

                    if (isFront) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                    break;
            }
        }
        if(deque.isEmpty())
            return "[]";

        StringBuilder sb = new StringBuilder("[");
        if(isFront) {
            while(!deque.isEmpty())
                sb.append(deque.pollFirst()).append(",");
        } else {
            while(!deque.isEmpty())
                sb.append(deque.pollLast()).append(",");
        }

        return sb.replace(sb.length() - 1, sb.length(), "]").toString();
    }
}
