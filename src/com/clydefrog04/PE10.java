//https://projecteuler.net/problem=10
package com.clydefrog04;

import com.clydefrog04.PEUtils.NumUtil;

public class PE10 {
    /*The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
     */

    public static void main(String[] args) {
        //a simple one since NumUtil handles prime check for us
        long sum = 0;
        NumUtil numUtil = new NumUtil();
        for (int i = 2; i < 2000000; i++) {
            if(numUtil.isPrime(i)){
                sum += i;
            }
        }
        System.out.printf("Sum is: %d%n", sum);
    }
}
