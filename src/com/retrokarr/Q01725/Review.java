package com.retrokarr.Q01725;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Review {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> heights = new ArrayList<>(N + 1);

        for(int i = 0 ; i < N ; ++i)
            heights.add(Integer.parseInt(br.readLine()));

        heights.add(0);
        int max = 0;
        Stack<Integer> remain = new Stack<>();
        for(int i = 0 ; i < heights.size() ; ++i) {
            while(!remain.isEmpty() && heights.get(remain.peek()) >= heights.get(i)) {
                int heightIdx = remain.pop();
                int width = 0;

                if(remain.isEmpty())
                    width = i;
                else
                    width = i - remain.peek() - 1;

                max = Math.max(max, width * heights.get(heightIdx));
            }
            remain.push(i);
        }

        bw.write(String.valueOf(max));
        bw.close();
        br.close();
    }
}
