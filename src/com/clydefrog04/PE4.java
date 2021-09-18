package com.clydefrog04;

import com.clydefrog04.PEUtils.StringUtil;

public class PE4 {
    /*
    A palindromic number reads the same both ways. The largest palindrome made from the
    product of two 2-digit numbers is 9009 = 91 × 99.

    Find the largest palindrome made from the product of two 3-digit numbers.
     */
    public static void main(String[] args) {
        StringUtil stringUtil = new StringUtil();
        int maxPalProd = 0;
        long start, end;
        start = System.nanoTime();
        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j < 999; j++) {
                int prod = i * j;
                String strProd = String.valueOf(prod);
                if(stringUtil.isPalindrome(strProd) && prod > maxPalProd){
                    maxPalProd = prod;
                }
            }
        }
        end = System.nanoTime();
        System.out.printf("Max pal prod found: %d%nFound in %,d nano seconds%n", maxPalProd, (end - start));
    }
}
