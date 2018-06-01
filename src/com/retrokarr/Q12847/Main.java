package com.retrokarr.Q12847;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int days = Integer.parseInt(st.nextToken());
        int serialDays = Integer.parseInt(st.nextToken());
        int[] salaries = new int [days + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= days ; ++i)
            salaries[i] = Integer.parseInt(st.nextToken());

        long ret = -1;
        long temp = 0L;
        for(int targetDay = 1 ; targetDay <= days ; ++targetDay) {
            if(targetDay > serialDays)
                temp -= salaries[targetDay - serialDays];

            temp += salaries[targetDay];
            ret = Math.max(ret, temp);
        }

        bw.write(String.valueOf(ret));
        bw.close();
    }
}
