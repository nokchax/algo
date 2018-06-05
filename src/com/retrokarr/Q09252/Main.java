package com.retrokarr.Q09252;

import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int[][] lcs = new int[a.length + 1][b.length + 1];

        for(int i = 1 ; i <= a.length ; ++i) {
            for(int j = 1 ; j <= b.length ; ++j) {
                if(a[i - 1] == b[j - 1])
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
            }
        }

        bw.write(String.valueOf(lcs[a.length][b.length]) + "\n");
        br.close();

        int i = a.length;
        int j = b.length;
        Stack<Character> stack = new Stack<>();
        while(lcs[i][j] != 0) {
            if(lcs[i][j] == lcs[i][j - 1]) {
                j--;
            } else if(lcs[i][j] == lcs[i - 1][j]) {
                i--;
            } else {
                stack.push(a[i - 1]);
                i--;
                j--;
            }
        }

        while(!stack.isEmpty())
            bw.write(String.valueOf(stack.pop()));

        bw.close();
    }
}
