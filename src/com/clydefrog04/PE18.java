//https://projecteuler.net/problem=18
//brief explanation of approach used, and a reminder to practice dynamic progamming :]
//https://www.geeksforgeeks.org/maximum-path-sum-triangle/

package com.clydefrog04;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class PE18 {

    private static ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

    private static void fillTriangle(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/files/PE18Triangle.txt"));
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                triangle.add(getIntAL(line));
//                System.out.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static ArrayList<Integer> getIntAL(String line){
        ArrayList<Integer> out = new ArrayList<>();
        String[] nums = line.split(" ");
        for (String num : nums) {
            out.add(Integer.parseInt(num));
        }
        return out;
    }

    public static void main(String[] args) {
        fillTriangle();
        System.out.println(triangle);

        int len = triangle.size();
        @SuppressWarnings("unchecked")
//        ArrayList<ArrayList<Integer>> sums = (ArrayList) triangle.clone();
        //String[][] stringArray = mainList.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
                Integer[][] sums = triangle.stream().map(u -> u.toArray(new Integer[len])).toArray(Integer[][]::new);
        System.out.println(Arrays.deepToString(sums));
        int[][] check = new int[10][10];
        System.out.println(Arrays.deepToString(check));

        System.out.println(len);
        int m = len - 1;
        System.out.println(m);
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(sums[i+1][j] > sums[i+1][j+1]){
                    sums[i][j] += sums[i+1][j];
                }else{
                    sums[i][j] += sums[i+1][j+1];
                }
            }

        }
        Integer n = 50;
        Integer y = null;
        System.out.println(sums[0][0]);


        /*
        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = 0; j <= i; j++)
            {
                // for each element, check both
                // elements just below the number
                // and below right to the number
                // add the maximum of them to it
                if (tri[i + 1][j] > tri[i + 1][j + 1])
                    tri[i][j] += tri[i + 1][j];
                else
                    tri[i][j] += tri[i + 1][j + 1];
            }
        }
         */
    }

}