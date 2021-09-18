//https://projecteuler.net/problem=99

package com.clydefrog04;

import java.io.*;

public class PE99 {

    public static void main(String[] args) {
        System.out.println(pow(519432,525806));
        try{
            File file = new File("src/files/p099_base_exp.txt");
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
//            BigInteger max = new BigInteger("0");
//            BigInteger base;
//            BigInteger expo;
//            BigInteger prod;
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
//                prod = new BigInteger(nums[0]).pow(Integer.parseInt(nums[1]));
//                System.out.println(line);
//                System.out.println(prod);
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

    /*
    int maxline = 0;
double maxnum = 0;
string[] lines = File.ReadAllLines(filename);
for (int i = 0; i < lines.Length; i++) {
    string[] line = lines[i].Split(',');
    double basenum = Math.Log(Convert.ToInt32(line[0]));
    int exponent = Convert.ToInt32(line[1]);
    double number = basenum * exponent;
    if (number > maxnum) {
        maxline = i+1;
        maxnum = number;
    }
}
     */

}
