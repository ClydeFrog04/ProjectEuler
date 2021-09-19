package com.clydefrog04;

import java.util.HashMap;
import java.util.Map;

public class PE14 {
    /*
    Possibly one of my favorite PE problems, and one of my favorite math problems/conjectures. I am very fascinated
    by this conjecture, and will likely provide a bit more comments to my solution;
The following iterative sequence is defined for the set of positive integers:
n → n/2 (n is even)
n → 3n + 1 (n is odd)
Using the rule above and starting with 13, we generate the following sequence:
13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
     */
    private static long getCollatz(long n) {
        if (n % 2 == 0) {
            return n / 2;
        } else return (3L * n) + 1;
    }

    private static final Map<Long, Long> cache = new HashMap<>();//cache of sequences found already

    public static void main(String[] args) {
        System.out.println(getCollatz(13));
        //for testing cache, we can limit our search to sequences below 100, expected result is:
        //The max sequence length of 119 found was for starting num 97
        //Iterations taken without cache: 3120 for a complexity of n^1.747
        //Iterations taken    with cache:  805 for a complexity of n^1.453
        /*The PE problem defines "under 1000000(one million)"
        using 1.453 as the exponent we can predict that with the cache we can
        find the answer in around 521660125 iterations.
        Actual results:
        The max sequence length of 556 found was for starting num 837799
        Iterations taken with cache: 5226262
        However, the actual results show n^1.1197.
        Far lower than the prediction :]
        The reason for this is that when the numbers are low, our cache is small, so we end up having to generate full
        sequences. As the numbers get larger, the chance of running into a number that is already in the cache is greater
        Which leads to a much smaller runtime for larger starting numbers.

        Run this program with the commented out prints to see what sequences use the cache, and which ones end up
        generating completely.
         */

        long count;
        long maxSeq = 0;
        long maxStart = 0;
        long curColl;
        long iterations = 0;
        long start, end;
        start = System.currentTimeMillis();
        for (long i = 1; i < 1000000; i++) {
//            System.out.printf("%d -> ", i);
            curColl = getCollatz(i);
            count = 2;//init to 2 because: i counts as a term, then curColl from i counts as a term
//            System.out.printf("%d -> ", curColl);
            iterations++;
            while (curColl != 1) {
                if (cache.containsKey(curColl)) {
                    count += cache.get(curColl);
                    break;
                }
                iterations++;
                curColl = getCollatz(curColl);
//                System.out.printf("%d -> ", curColl);
                count++;
            }
            if (count > maxSeq) {
                maxSeq = count;
                maxStart = i;
            }
            cache.put(i, count);
//            System.out.printf("%nColl seq length for starting num %d was %d%n", i, count);
        }
        end = System.currentTimeMillis();
        System.out.printf("The max sequence length of %d found was for starting num %d%n", maxSeq, maxStart);
        System.out.printf("Iterations taken with cache: %d%nAnswer found in %d ms", iterations, end - start);
    }
}
