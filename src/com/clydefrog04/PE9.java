package com.clydefrog04;

import com.clydefrog04.PEUtils.NumUtil;

public class PE9 {
    /*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a^2 + b^2 = c^2

For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
     */

    public static void main(String[] args) {
        //this is an AWFUL approach to this problem. It works because the search set is so small, but will
        //certainly not scale well.
        //A better approach can be read here:
        //https://www.mathblog.dk/pythagorean-triplets/
        NumUtil numUtil = new NumUtil();
        System.out.println(numUtil.isPythagoreanTriplet(3, 4, 5));

        for (int a = 0; a < 1000; a++) {
            for (int b = a; b < 1000; b++) {
                for (int c = b; c < 1000; c++) {
                    if(a + b + c == 1000 && numUtil.isPythagoreanTriplet(a, b, c)){
                        System.out.printf("Prod abc: %d%n", a * b * c);
                        break;
                    }
                }
            }
        }
    }
}
