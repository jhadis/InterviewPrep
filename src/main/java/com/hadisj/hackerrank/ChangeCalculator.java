package com.hadisj.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by admin on 8/13/17.
 */
public class ChangeCalculator {

    static int findLeastNumberOfCoinsForChange(int requiredChange, List<Integer> coinDenominations) {
        int currentChange = requiredChange;
        int coinsUsed = 0;
        coinDenominations.sort(Comparator.<Integer>reverseOrder());
        while (currentChange > 0) {
            for (Integer denomination: coinDenominations) {
                if (denomination <= currentChange) {
                    currentChange -= denomination;
                    System.out.println(currentChange + " : " +denomination);
                    coinsUsed++;
                    break;
                }
            }
            //circuit breaker for when the denominations aren't appropriate
//            if (currentChange - coinDenominations.get(coinDenominations.size()-1) < 0)
//                break;
        }

        return coinsUsed;
    }

    public static void main(String[] args) {
        int coinUsed = ChangeCalculator.findLeastNumberOfCoinsForChange(43, Arrays.asList(1, 5, 25));
        System.out.println("Number of Coins Used: " +coinUsed);
    }
}
