//https://projecteuler.net/problem=12
package com.clydefrog04;

import com.clydefrog04.PEUtils.NumUtil;

public class PE12 {

    public static void main(String[] args) {
        NumUtil numUtil = new NumUtil();

        long triangleNum = 1;
        int i = 2;
        while(numUtil.countFactors(triangleNum) < 500){
            triangleNum += i++;
        }
        System.out.println(triangleNum);
    }
}
