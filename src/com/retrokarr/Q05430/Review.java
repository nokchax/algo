package com.retrokarr.Q05430;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Review {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0)
            bw.write(solve() + "\n");
        bw.close();
        br.close();
    }

    static String solve() throws IOException {
        char[] cmds = br.readLine().toCharArray();
        br.readLine();
        String temp = br.readLine();
        temp = temp.substring(1, temp.length() - 1);
        String[] inputs = temp.split(",");
        Deque<Integer> dq = new LinkedList<>();
        for(String input : inputs) {
            if(input.isEmpty()) continue;
            dq.addLast(Integer.parseInt(input));
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean forward = true;
        for(char cmd : cmds) {
            switch(cmd) {
                case 'R':
                    forward = !forward;
                    break;

                case 'D':
                    if(dq.isEmpty())
                        return "error";
                    if(forward)
                        dq.pollFirst();
                    else
                        dq.pollLast();
                    break;
            }
        }

        if(dq.isEmpty())
            sb.append(',');
        else {
            if(forward) {
                while(!dq.isEmpty())
                    sb.append(dq.pollFirst()).append(',');
            } else {
                while(!dq.isEmpty())
                    sb.append(dq.pollLast()).append(',');
            }
        }
        sb.replace(sb.length() - 1, sb.length(), "]");

        return sb.toString();
    }
}
