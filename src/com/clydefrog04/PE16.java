//https://projecteuler.net/problem=16

package com.clydefrog04;

import java.math.BigInteger;

public class PE16 {

    private static void solution(){
        BigInteger bigInteger = new BigInteger("2");
        System.out.println(bigInteger.pow(1000));
        long sum = 0;
        BigInteger product = bigInteger.pow(1000);
        String[] prodArr = product.toString().split("");

        for (String s : prodArr) {
            sum += Integer.parseInt(s);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        solution();
    }
}