package com.retrokarr.codility.Q01;

public class Solution {
    public int solution(int N) {
        int ret = 0;
        int temp = 0;
        boolean one = false;

        while(N > 0) {
            int remain = N % 2;
            N /= 2;

            if(remain != 1) {
                if(one)
                    temp++;
                continue;
            }

            one = true;
            ret = Math.max(ret, temp);
            temp = 0;
        }

        return ret;
    }
}
