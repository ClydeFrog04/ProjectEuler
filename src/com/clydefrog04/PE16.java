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


/*


2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?

 */