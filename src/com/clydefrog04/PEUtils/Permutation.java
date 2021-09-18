//https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

package com.clydefrog04.PEUtils;

import java.util.ArrayList;

public class Permutation {

    ArrayList<String> permutations;

    public Permutation(){
        this.permutations = new ArrayList<>();
        //permutation.permute(str, 0, n - 1);
    }

    public ArrayList<String> getPermutations(String str){
        this.permutations.clear();
        permute(str, 0, str.length() - 1);
        return this.permutations;
    }

    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     **/
    private void permute(String str, int l, int r) {
        if (l == r) {
            permutations.add(str);
        }
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);

            }
        }
    }

    public ArrayList<String> getRotations(String str){
        permutations.clear();
        if(str.length() <= 1) {
            permutations.add(str);
        }else {
            for (int i = 0; i < str.length(); i++) {
                permutations.add(str);
                str = str.substring(1) + str.charAt(0);
            }
        }
        return permutations;
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     **/
    public String swap(String a, int i, int j){
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}