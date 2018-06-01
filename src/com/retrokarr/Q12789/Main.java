package com.retrokarr.Q12789;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int students = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < students ; ++i)
            q.add(Integer.parseInt(st.nextToken()));

        int target = 1;
        boolean impossible = false;
        while(target < students) {
            if(!q.isEmpty() && q.peek() == target) {
                q.poll();
                target++;
            } else if(!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                target++;
            } else {
                if(q.isEmpty()) {
                    impossible = true;
                    break;
                } else {
                    stack.push(q.poll());
                }
            }
        }

        bw.write(impossible ? "Sad" : "Nice");
        bw.close();
    }
}
