package com.clydefrog04;

public class PE5 {

    /*
    2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
    What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
     */

    public static void main(String[] args) {
        //some other shortcuts that can be made:
            /*
            numbers we can skip checks for and reasoning:
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
            all numbers are divisible by 1, so we can skip that
            because  5 * 4 = 20, if n is divisible by 20, it is also divisible by 5 and 4
            because 10 * 2 = 20, if n is divisible by 20, it is also divisible by 10 and 2
            because  9 * 2 = 18, if n is divisible by 18, it is also divisible by 9 and 2
            because  6 * 3 = 18, if n is divisible by 18, it is also divisible by 6 and 3
            because  8 * 2 = 16, if n is divisible by 16, it is also divisible by 8 and 2
            //same rule applies for 3 * 5 = 15, but 3 and 5 have already been crossed out
            because  7 * 2 = 14, if n is divisible by 14, it is also divisible by 7 and 2
            because 18 and 15 cross out 3, and 20 crosses out 4, we can skip 12 as well
            I think we can check 11-20* and eliminate all other checks. *skipping 12 as well
             */
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 1; i < Integer.MAX_VALUE; i++) {//it is a reasonable assumption this number will be less than maxint
            if(
                    i % 20 == 0 &&
                    i % 19 == 0 &&
                    i % 18 == 0 &&
                    i % 17 == 0 &&
                    i % 16 == 0 &&
                    i % 15 == 0 &&
                    i % 14 == 0 &&
                    i % 13 == 0 &&
                    i % 11 == 0){
                end = System.currentTimeMillis();
                System.out.printf("The smallest num divisible by 1-20 is %d%nFound in %,d micro seconds",
                                                                          i,          (end - start));
                break;
            }

        }
    }
}
