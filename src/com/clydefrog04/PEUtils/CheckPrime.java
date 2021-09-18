package com.clydefrog04.PEUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @deprecated
 * This class has been replaced by NumUtil.
 * NumUtil was written to be a more generic number utility,
 * while this class was written only to check for primes
 */
public class CheckPrime {

    private List<Integer> sieve;
    int limit;

    public CheckPrime(){
        this.limit = 1000000;
        this.sieve = new ArrayList<>();
        generateSieve(limit);

    }

    private void generateSieve(int limit){
        Integer[] ones = new Integer[limit];
        Arrays.fill(ones, 1);
        sieve = new ArrayList<>(Arrays.asList(ones));
        sieve.set(0, 0);
        sieve.set(1, 0);

        int i = 2;

        while (i <= (int) Math.sqrt(limit)) {
            if (sieve.get(i) == 0) {
                i++;
                continue;
            }
            int j = 2 * i;
            while (j < limit){
                sieve.set(j, 0);
                j += i;
            }
            i++;
        }
    }

    public boolean isPrimeWithSieve(int n) {
        return sieve.get(n) == 1;
    }
}


/*
public class PrimeMethods {

    private static List<Integer> sieve;


    private static boolean isPrimeWithSieve(int n) {
        int loopCount = 0;
        loopCount++;
        System.out.printf("Answer found, loop iterations needed: %d", loopCount);
        return sieve.get(n) == 1;
    }
 */