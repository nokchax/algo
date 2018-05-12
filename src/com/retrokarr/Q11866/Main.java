package com.retrokarr.Q11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        Queue<Integer> q = new LinkedList<>();
        List<String> answer = new ArrayList<>();

        int nums = Integer.parseInt(inputs[0]);
        int skip = Integer.parseInt(inputs[1]);

        for(int i = 1 ; i <= nums ; ++i)
            q.add(i);

        while(!q.isEmpty()) {
            for(int i = 1 ; i < skip ; ++i)
                q.add(q.poll());

            answer.add(String.valueOf(q.poll()));
        }

        System.out.println("<" + String.join(", ", answer) + ">");
    }
}
/**
 int index = 0;
 while (!list.isEmpty()) {
     index += m;
     if (index >= list.size()) {
         index %= list.size();
     }
     sb.append(list.remove(index) + ", ");
 }
 */
