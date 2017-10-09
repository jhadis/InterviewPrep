package com.hadisj.hackerrank.tutorial;

import java.util.*;

/**
 * Created by admin on 9/18/17.
 *
 * You receive as input a set of people. You need to output a random and uniform list of pairs of these people for giving
 * gifts to each other. E.g. the first person in the pair gives a gift to the second person in the pair. Make sure that
 * everyone gets a gift and it is not allowed for a giver of a gift to receive a gift from the recipient of his gift.
 */
public class GiftDistribution {

    List<String> people = new ArrayList<>();
    List<List<String>> giftPairings;

    GiftDistribution(String[] peopleInput) {
        giftPairings = new ArrayList<>(peopleInput.length / 2);

        for (String person : peopleInput) {
            people.add(person);
        }
    }

    List<List<String>> getGiftPairings() {
        if (giftPairings == null)
            return null;

        Random random = new Random();
        while (people.size() >= 2) {
            int giverIndex = random.nextInt(people.size() - 1);
            String giver = people.remove(giverIndex);
            int receiverIndex = 0;
            if (people.size() > 1)
                receiverIndex = random.nextInt(people.size() - 1);
            String receiver = people.remove(receiverIndex);
            List<String> pair = new ArrayList<>(2);
            pair.add(giver);
            pair.add(receiver);
            giftPairings.add(pair);

            //If there was an odd number of people, then give the odd man out a gift from the most recent giver
            if (people.size() == 1) {
                pair = new ArrayList<>(2);
                pair.add(giver);
                pair.add(people.get(0));
                giftPairings.add(pair);
            }
        }

        return giftPairings;
    }

    public static void main(String[] args) {
        String[] people = new String[] {"Bob", "Irma", "Bill", "Mike", "Ted", "Roz", "Sally", "Meghan", "Jack"};
        System.out.println("Initial set of people: ");
        for (String s: people) {
            System.out.print(s + ", ");
        }

        GiftDistribution app = new GiftDistribution(people);
        List<List<String>> pairings = app.getGiftPairings();
        System.out.println("Gift pairings: ");
        for (List<String> list : pairings) {
            System.out.println(list);
        }
    }
}
