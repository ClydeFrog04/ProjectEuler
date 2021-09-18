//https://projecteuler.net/problem=99

package com.clydefrog04;

import java.io.*;

public class PE99 {

    public static void main(String[] args) {
        System.out.println(pow(519432,525806));
        try{
            File file = new File("src/files/p099_base_exp.txt");
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            long max = 0;
            long maxLine = 0;
            int i = 0;

            String line = "";
            while(line != null){
                line = fileReader.readLine();
                if(line == null) break;

                String[] nums = line.split(",");
                long prod = pow(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
                if(prod > max){
                    max = prod;
                    maxLine = i;
                }
                i++;
            }
            System.out.println(maxLine);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    static long pow(int base, int expo){
        double baseNum = Math.log(base);
        return (long)baseNum * expo;

    }
}
