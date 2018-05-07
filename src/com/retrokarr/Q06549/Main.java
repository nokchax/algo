package com.retrokarr.Q06549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;

        while(true) {
            input = br.readLine();
            String[] inputs = input.split(" ");

            if(inputs.length == 1 && inputs[0].equals("0")) break;

            List<Integer> heights = new ArrayList<>();
            for(int i = 1 ; i < inputs.length ; ++i)
                heights.add(Integer.parseInt(inputs[i]));

            sb.append(solve(heights)).append('\n');
        }

        System.out.println(sb.toString());
    }


    private static long solve(List<Integer> heights) {
        long ret = 0L;
        heights.add(0);
        Stack<Integer> remains = new Stack<>();

        for(int i = 0 ; i < heights.size() ; ++i) {
            while(!remains.isEmpty() && heights.get(remains.peek()) >= heights.get(i)) {
                int j = remains.pop();
                long width = -1;

                if(remains.isEmpty()) width = i;
                else width = i - remains.peek() - 1;

                ret = Math.max(ret, (width * heights.get(j)));
            }

            remains.push(i);
        }

        return ret;
    }
}
