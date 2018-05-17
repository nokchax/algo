package com.retrokarr.Q01021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        Deque<Integer> deque = new LinkedList<>();

        int size = Integer.parseInt(inputs[0]);
        int toPick = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        for(int i = 1 ; i <= size ; ++i)
            deque.add(i);

        int moveCount = 0;

        int target = 0;
        while(target < toPick) {
            int targetNum = Integer.parseInt(inputs[target]);

            if(targetNum != deque.peekFirst()) {
                int index = ((LinkedList<Integer>) deque).indexOf(targetNum);

                if(index <= deque.size() / 2) {
                    while(deque.peekFirst() != targetNum) {
                        deque.addLast(deque.pollFirst());
                        moveCount++;
                    }
                } else {
                    while(deque.peekFirst() != targetNum) {
                        deque.addFirst(deque.pollLast());
                        moveCount++;
                    }
                }
            }

            deque.poll();
            target++;
        }

        System.out.println(moveCount);
    }
}
