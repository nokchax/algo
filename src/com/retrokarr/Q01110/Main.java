package com.retrokarr.Q01110;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int origin = x;
        int tryCount = 1;

        while(origin != (x = getNextNum(x))) {
            tryCount++;
        }

        bw.write(String.valueOf(tryCount));
        bw.close();
    }
    private static int getRightNum(int x) {
        return x % 10;
    }

    private static int getLeftNum(int x) {
        return x / 10;
    }
    private static int getNextNum(int before) {
        int beforeRight = getRightNum(before);
        int after = beforeRight + getLeftNum(before);
        int afterRight = getRightNum(after);

        return beforeRight * 10 + afterRight;
    }
}
