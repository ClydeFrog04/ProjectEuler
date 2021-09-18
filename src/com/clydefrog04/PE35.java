package com.clydefrog04;

import com.clydefrog04.PEUtils.CheckPrime;
import com.clydefrog04.PEUtils.Permutation;

import java.util.ArrayList;

public class PE35 {

    static ArrayList<Integer> foundCirculars = new ArrayList<>();//this way we don't calculate ones found already
    static CheckPrime checkPrime = new CheckPrime();


    public static void main(String[] args) {
        String str = "314";
        int n = str.length();
        Permutation permutation = new Permutation();
        ArrayList<String> perms = permutation.getPermutations(str);
        System.out.println(perms);
        System.out.println(checkPrime.isPrimeWithSieve(71));
        System.out.printf("Is %d circular: %b%n", 197, isCircularPrime(197));
        System.out.println(permutation.getRotations("197"));

        int count = 0;
        for (int i = 0; i < 1000000; i++) {
            if(isCircularPrime(i)) count ++;
        }
        System.out.println(count);
    }

    private static boolean isCircularPrime(int n){
        if(foundCirculars.contains(n)) return true;
        else{
            Permutation permutation = new Permutation();
            ArrayList<String> perms = permutation.getRotations(String.valueOf(n));
            for (String perm : perms) {
                if(!checkPrime.isPrimeWithSieve(Integer.parseInt(perm))) return false;
            }
            foundCirculars.add(n);
            return true;
        }
    }
}
/*
public static void main(String[] args)
    {
        String str = "ABC";
        int n = str.length();
        Permutation permutation = new Permutation();
        permutation.permute(str, 0, n-1);
    }
 */