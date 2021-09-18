package com.clydefrog04;

import java.util.HashMap;
import java.util.Map;

public class PE17 {

    static Map<Integer, String> ones = new HashMap<Integer, String >(){{//todo: this can totally be refactored to already contain the word score,
        // there is absolutely no reason we actually need to generate the string words
        put(1, "one");
        put(2, "two");
        put(3, "three");
        put(4, "four");
        put(5, "five");
        put(6, "six");
        put(7, "seven");
        put(8, "eight");
        put(9, "nine");
        put(10, "ten");
    }};

    static Map<Integer, String> tens = new HashMap<Integer, String >(){{
        put(1, "ten");
        put(2, "twenty");
        put(3, "thirty");
        put(4, "forty");
        put(5, "fifty");
        put(6, "sixty");
        put(7, "seventy");
        put(8, "eighty");
        put(9, "ninety");
    }};

    static Map<Integer, String> specialCases = new HashMap<Integer, String >(){{
        put(11, "eleven");
        put(12, "twelve");
        put(13, "thirteen");
        put(14, "fourteen");
        put(15, "fifteen");
        put(16, "sixteen");
        put(17, "seventeen");
        put(18, "eighteen");
        put(19, "nineteen");
    }};

    public static void main(String[] args) {
        /*
        I am going to attempt this first by breaking the numbers up into groups.
        Group 1 will be: 0-99
        Group 2 will be: the hundreds
        Group 3 will be the single 1000

        To expand on this, I and going to write the 0-99's, and then I should be able to reuse those for the hundreds
        That way the hundreds can be written as a loop of 9 and then append the 0-99's to those on each pass

        this is even easier than I thought. Aside from straight hundreds(100 200 (both end in double zero) and so on)
        all hundreds are going to be x hundred and SOMETENS SOMEONES
        then we just need to account for special cases such as the teens
         */
//        getNumberScore(100);
//        System.out.println(getOnesScore(7));
        int sum = 11;//init with 11 to cover onethousand
//        System.out.println("onethousand".length());
        for (int i = 1; i < 1000; i++) {
            sum += getNumberScore(i);
        }
        System.out.printf("Sum found: %d", sum);


    }

    private static int getNumberScore(int n){//incomplete, needs to include "ten" for the hundreds, it does not currently.
        String numStr = "";

        if(n < 11){
            numStr += ones.getOrDefault(n, "");
        }else if(n % 100 > 0 && n % 100 < 11){
            numStr += getHundredsScore(n) + getOnesScore(n % 100);
        }else{
            numStr += getHundredsScore(n) + getTensScore(n % 100);
        }

//        System.out.println(numStr);
        return numStr.length();
    }

    private static String getOnesScore(int n){//call only if n is less than 10 otherwise use get tens score
//        System.out.println(n % 10);
        return ones.getOrDefault(n % 10, "");
    }

    private static String getTensScore(int n){
        String numStr = "";
        if(n < 20){//special cases(the teens)
            numStr += specialCases.getOrDefault(n, "");
        }else if(n < 100){
            if(n % 10 == 0){
                numStr += tens.getOrDefault(n / 10, "");
            }else{
                numStr += tens.getOrDefault(n / 10, "");
                numStr += ones.getOrDefault(n % 10, "");
            }
        }
        return numStr;
    }

    private static String getHundredsScore(int n){
        String numStr =  "";

        if(n / 100 > 0){
            numStr += ones.getOrDefault(n / 100, "") + "hundred";
            if(n % 100 != 0){
                numStr += "and";
            }
        }
        return numStr;
    }
}



/*


If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19
letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115
(one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British
usage.

 */