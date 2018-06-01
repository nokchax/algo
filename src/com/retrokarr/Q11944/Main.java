package com.retrokarr.Q11944;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        String temp = st.nextToken();
        int length = temp.length();
        int repeatTime = Integer.parseInt(temp);
        int maxLength = Integer.parseInt(st.nextToken());

        repeatTime = maxLength > (length * repeatTime) ? repeatTime : maxLength / length + 1;
        StringBuilder sb = new StringBuilder();

        while(repeatTime-- > 0)
            sb.append(temp);

        bw.write(sb.length() > maxLength ? sb.substring(0, maxLength) : sb.toString());
        bw.close();
        br.close();
    }
}
