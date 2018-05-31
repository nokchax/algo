package com.retrokarr.Q06549;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Review {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numOfRec = Integer.parseInt(st.nextToken());

            if(numOfRec == 0)
                break;

            List<Integer> heigths = new ArrayList<>(numOfRec + 1);
            for(int i = 0 ; i < numOfRec ; ++i)
                heigths.add(Integer.parseInt(st.nextToken()));

            bw.write(solve(heigths) + "\n");
        }

        bw.close();
    }

    static String solve(List<Integer> heights) {
        heights.add(0);
        Stack<Integer> remains = new Stack<>();
        long ret = 0L;

        for(int i = 0 ; i < heights.size() ; ++i) {
            while(!remains.isEmpty() && heights.get(remains.peek()) >= heights.get(i)) {
                int j = remains.pop();
                long width = 0;

                if(remains.isEmpty())
                    width = i;
                else
                    width = i - remains.peek() - 1;

                ret = Math.max(ret, heights.get(j) * width);
            }

            remains.add(i);
        }

        return String.valueOf(ret);
    }
}
