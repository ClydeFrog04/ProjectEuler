package com.clydefrog04;

import com.clydefrog04.PEUtils.NumUtil;

public class PE7 {

    public static void main(String[] args) {
        NumUtil numUtil = new NumUtil();
        int numPrimesFound = 0;
        long currentPrime = 0;
        int i = 1;
        while(numPrimesFound < 10001){
            if(numUtil.isPrime(i)){
                numPrimesFound++;
                currentPrime = i;
            }
            i++;
        }
        System.out.printf("Prime found %d%n", currentPrime);
    }
}
