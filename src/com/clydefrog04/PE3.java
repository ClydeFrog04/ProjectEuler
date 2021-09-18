//https://projecteuler.net/problem=3

package com.clydefrog04;

import com.clydefrog04.PEUtils.CheckPrime;

public class PE3 {

    public static void main(String[] args) {
        long lim = 600851475143L;

        long start = System.currentTimeMillis();
        CheckPrime checkPrime = new CheckPrime();
        for (int i = (int)Math.sqrt(lim); i > 0; i--) {
            if(checkPrime.isPrimeWithSieve(i) && lim % i == 0){
                System.out.println("Found: " + i);
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
