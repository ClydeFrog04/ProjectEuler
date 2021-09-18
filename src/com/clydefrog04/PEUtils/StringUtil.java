package com.clydefrog04.PEUtils;

public class StringUtil {


    public boolean isPalindrome(String in){

        int inLen = in.length();
        for (int i = 0; i < inLen / 2; i++) {
            if(in.charAt(i) != in.charAt(inLen - i - 1)) return false;
        }
        return true;
    }
}
