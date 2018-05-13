package com.retrokarr.Q01966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(testCase-- > 0) {
            sb.append(solve()).append('\n');
        }

        System.out.println(sb);
    }

    private static int solve() throws IOException {
        String[] inputs = br.readLine().split(" ");
        int nums = Integer.parseInt(inputs[0]);
        int target = Integer.parseInt(inputs[1]);
        int ret = 1;
        inputs = br.readLine().split(" ");
        Queue<int[]> q = new LinkedList<>();
        List<Integer> priority = new ArrayList<>();

        for(int i = 0 ; i < nums ; ++i) {
            int num = Integer.parseInt(inputs[i]);
            q.add(new int[]{i, num});
            priority.add(num);
        }

        Collections.sort(priority);

        while(!q.isEmpty()) {
            int[] temp = q.peek();

            if(temp[1] == priority.get(priority.size() - 1)) {
                if(temp[0] == target)
                    break;

                q.poll();
                priority.remove(priority.size() - 1);
                ret++;
                continue;
            }

            q.add(q.poll());
        }

        return ret;
    }
}
