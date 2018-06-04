package com.retrokarr.Q11403;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for(int i = 0 ; i < n ; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; ++j)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int k = 0 ; k < n ; ++k) {
            for(int i = 0 ; i < n; ++i) {
                for(int j = 0 ; j < n ; ++j) {
                    if(map[i][j] == 0 && map[i][k] == 1 && map[k][j] == 1)
                        map[i][j] = 1;
                }
            }
        }

        for(int i = 0 ; i < n ; ++i) {
            for(int j = 0 ; j < n ;++j) {
                bw.write(String.valueOf(map[i][j] + " "));
            }
            bw.write("\n");
        }

        bw.close();
        br.close();
    }
}
