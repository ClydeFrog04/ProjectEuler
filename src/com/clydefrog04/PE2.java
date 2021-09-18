// https://projecteuler.net/problem=2

package com.clydefrog04;
/*
Each new term in the Fibonacci sequence is generated by adding the previous two terms.
By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values do not
exceed four million, find the sum of the even-valued terms.
 */

import com.clydefrog04.PEUtils.NumUtil;

public class PE2 {

    public static void main(String[] args) {
        NumUtil numUtil = new NumUtil();

        System.out.println(numUtil.getFibN(1));//1
        System.out.println(numUtil.getFibN(2));//1
        System.out.println(numUtil.getFibN(3));//2
        System.out.println(numUtil.getFibN(4));//3
        System.out.println(numUtil.getFibN(5));//5
        System.out.println(numUtil.getFibN(6));//8

        long sumEven = 0;

        int n = 2;
        long fibN = numUtil.getFibN(n++);

        long start, end;
        start = System.nanoTime();
        while(fibN <= 4000000){
            fibN = numUtil.getFibN(n++);
            if(fibN % 2 == 0) sumEven += fibN;
        }
        end = System.nanoTime();
        System.out.printf("Sum of even fib nums: %d%n found in %,d nano seconds", sumEven, end - start);
    }
}
