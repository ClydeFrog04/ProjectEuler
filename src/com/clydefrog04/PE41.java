//https://projecteuler.net/problem=41

package com.clydefrog04;

import com.clydefrog04.PEUtils.NumUtil;

public class PE41 {

    public static void main(String[] args) {
        //limit can be 987654321 since that is the largest possible pandigital number
        int limit = 987654321;
        int maxPP = 0;
        NumUtil numUtil = new NumUtil();
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 3; i < limit; i++) {
            boolean isPP = numUtil.improvedPan(i) && numUtil.isPrime(i);
            if (isPP && i > maxPP) maxPP = i;
        }
        end = System.currentTimeMillis();
        System.out.printf("Largest found pandigital prime was: %d%n Time taken: %ds%n", maxPP, (end - start) / 1000);
    }
}
