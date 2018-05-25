package com.retrokarr.Q01152;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int ret = 0;

        while(st.hasMoreTokens())
            if(!st.nextToken().isEmpty())
                ret++;

        bw.write(String.valueOf(ret));
        bw.close();
    }
}
