package com.clydefrog04;

import java.math.BigInteger;

public class PE97 {
    /*
The first known prime found to exceed one million digits was discovered in 1999, and is a Mersenne prime of the form
26972593−1; it contains exactly 2,098,960 digits. Subsequently other Mersenne primes, of the form 2p−1, have been found
which contain more digits.

However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits: 28433×2^(7830457)+1.

Find the last ten digits of this prime number.
     */

    public static void main(String[] args) {
        BigInteger x = new BigInteger("28433");
        BigInteger base = new BigInteger("2");
//        BigInteger exponent = new BigInteger("7830457");

        BigInteger product = base.pow(7830457);
        product = x.multiply(product);
        product = product.add(new BigInteger("1"));
        int length = product.toString().length();
        System.out.println(product.toString().substring(length - 10));
    }
}
