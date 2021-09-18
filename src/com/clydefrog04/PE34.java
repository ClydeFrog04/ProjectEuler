//https://projecteuler.net/problem=34

package com.clydefrog04;

import java.util.HashMap;
import java.util.Map;

public class PE34 {

    static Map<Integer, Integer> factorials = new HashMap<Integer, Integer>(){{
        put(0, 1);
        put(1, 1);
        put(2, 2);
        put(3, 6);
        put(4, 24);
        put(5, 120);
        put(6, 720);
        put(7, 5040);
        put(8, 40320);
        put(9, 362880);
    }};

    public static void main(String[] args) {
        System.out.println(getFactSum(145));
        System.out.println(Long.MAX_VALUE);
        long max = 9223372036854775807L;

        long sum = 0;
        for (long i = 3; i < max; i++) {
            if(i == getFactSum(i)){
                sum += i;
                System.out.println(i);
            }
        }
        System.out.println(sum);
    }

    private static long getFactSum(long n){
        long sum = 0;

        while (n > 0){
//            System.out.println(n % 10);
            sum += factorials.get((int)n % 10);
            n /= 10;
        }

        return sum;
    }
}
