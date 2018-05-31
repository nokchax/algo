package com.retrokarr.Q01009;

import java.io.*;
import java.util.StringTokenizer;

/*
* while( testCase-- > 0 ){
			int a = sc.nextInt()%10, b = (sc.nextInt() - 1) % 4 + 1;
			// 모든 1의자리를 거듭제곱 할 경우 아무리 길어도 a^1 == a^5이 성립
			int i = a;
			while( b-- > 1 )
				a = (a%10) * i;

			System.out.println( (a%10 == 0) ? 10 : a%10  );
		}
* */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        int[] cache = new int[10];
        cache[0] = cache[1] = cache[5] = cache[6] = 1;
        cache[2] = cache[3] = cache[7] = cache[8] = 4;
        cache[4] = cache[9] = 2;

        while(testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) % 10;
            int b = Integer.parseInt(st.nextToken());
            b %= cache[a];
            if(b == 0) b = cache[a];
            a = (int) Math.pow(a, b);
            a %= 10;

            bw.write(a == 0 ? "10\n" : String.valueOf(a) + "\n");
        }

        bw.close();
    }
}
