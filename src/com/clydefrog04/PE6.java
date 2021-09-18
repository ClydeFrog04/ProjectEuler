package com.clydefrog04;

public class PE6 {

    /*
    The sum of the squares of the first ten natural numbers is,
1^2 + 2^2 + ... + 10^2 = 385
The square of the sum of the first ten natural numbers is,
(1 + 2 ... + 10)^2 = 55^2 == 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
3025 - 385 = 2640
Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/
    public static void main(String[] args) {
        long sum = 0;
        long plusFact = 0;//not sure best name for this, it will be a continuing count that can be squared later
        //later we can do plusFact^2 - sum to get the diff
        for (int i = 1; i <= 100; i++) {
            sum += Math.pow(i, 2);
            plusFact += i;
        }
        System.out.printf("The difference is %d%n", (int)Math.pow(plusFact, 2) - sum);
    }
}
