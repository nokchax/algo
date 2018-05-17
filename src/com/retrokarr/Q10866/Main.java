package com.retrokarr.Q10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cmdCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();

        while(cmdCount-- > 0) {
            String[] cmd = br.readLine().split(" ");

            switch(cmd[0]) {
                case "push_back":
                    deque.addLast(Integer.parseInt(cmd[1]));
                    break;

                case "push_front":
                    deque.addFirst(Integer.parseInt(cmd[1]));
                    break;

                case "front":
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
                    break;

                case "back":
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
                    break;

                case "size":
                    sb.append(deque.size()).append('\n');
                    break;

                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append('\n');
                    break;

                case "pop_front":
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n');
                    break;

                case "pop_back":
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append('\n');
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
