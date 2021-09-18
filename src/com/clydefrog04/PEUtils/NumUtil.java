package com.clydefrog04.PEUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumUtil {

    private List<Integer> sieve;
    int limit;

    public NumUtil(){
        this.limit = 1000000;
        this.sieve = new ArrayList<>();
        generateSieve(limit);
    }

    private void generateSieve(int limit){
        Integer[] ones = new Integer[limit];
        Arrays.fill(ones, 1);
        sieve = new ArrayList<>(Arrays.asList(ones));
        sieve.set(0, 0);
        sieve.set(1, 0);

        int i = 2;

        while (i <= (int) Math.sqrt(limit)) {
            if (sieve.get(i) == 0) {
                i++;
                continue;
            }
            int j = 2 * i;
            while (j < limit){
                sieve.set(j, 0);
                j += i;
            }
            i++;
        }
    }

    public boolean isPrime(int n) {//todo: refactor to long, potentially make a bigint/string version as well
        //we have a point where generating a large sieve takes longer than a brute force check, so we compromise
        if(n > sieve.size()) return forcePrime(n);
        return sieve.get(n) == 1;
    }

    private boolean forcePrime(int n){
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public boolean isPandigital(long n){
        String nStr = String.valueOf(n);
        int lim = nStr.length();
        /*
        Some rules about pandigital nums:
        -They can at most be of length 9- 1,2,3,4,5,6,7,8,9 are the only possible digits since the rule is 1-n
        and each digit occuring only one time.
        -any num containing the digit 0 is not pandigital, and we can simply return false
         */
        //initial rule checks before doing further processing
        if(lim > 9 || nStr.contains("0")) return false;
        for (int i = 0; i < lim; i++) {
            //probably a terrible way to do this :]
            int testN = i + 1;
            if(!nStr.contains("" + testN)) return false;
            int indexOfN = nStr.indexOf("" + testN);
            if(indexOfN < 0) return false;
            nStr = nStr.substring(0, indexOfN) + nStr.substring(indexOfN + 1);
        }
        return nStr.length() == 0;
    }

    public boolean improvedPan(long n){
        //this version taken from someone much smarter than me :]
        //answer from: Andras Vass
        //in thread https://stackoverflow.com/questions/2484892/fastest-algorithm-to-check-if-a-number-is-pandigital
        int digits = 0;
        int count = 0;
        int tmp;
        for(; n > 0; n /=10, ++count){
            if(digits == (digits |= 1 <<(n - ((n / 10) * 10) - 1))){
                return false;
            }
        }
        return digits == (1 << count) - 1;
    }

    public long getFibN(int term){
        //a function to get a fibonacci term rather than generating the entire sequence
        // maths from people much smarter than me:
        //http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html
        double sqrt5 = Math.sqrt(5);
        double Phi = (sqrt5 + 1) / 2;
        double phi = Phi - 1;
        double PhiToN = Math.pow(Phi, term);
        double negphiToN = Math.pow(-phi, term);
        double nthFib = (PhiToN - negphiToN) / sqrt5;
        return (long) nthFib;
    }

}
