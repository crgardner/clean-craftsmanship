package org.crg.kata.poker;

import java.util.*;
import java.util.stream.Collectors;

class TwoPairClassification extends HandClassification {

    TwoPairClassification(int[] cardValues) {
       super(cardValues);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playTwoPairs(cardValues());
    }

    @Override
    Result playTwoPairs(int[] cardValues) {
        return determinePairResult(cardValues);
    }

    private Result determinePairResult(int[] otherCardValues) {
        if (lowestPair() > lowestPair(otherCardValues)) {
            return Result.LOSE;
        }

        if (lowestPair() < lowestPair(otherCardValues)) {
            return Result.WIN;
        }

        return determineResult(otherCardValues);

    }

    private Integer lowestPair() {
        return lowestPair(cardValues());
    }

    private Integer lowestPair(int[] currentCardValues) {
        var cardCounts = Arrays.stream(currentCardValues).boxed()
                               .collect(Collectors.groupingBy(c -> c, Collectors.counting()));


        var pair = cardCounts.entrySet()
                                            .stream()
                                            .filter(e -> e.getValue().equals(2L))
                                            .findFirst().map(Map.Entry::getKey);


        return pair.orElse(-1);
    }

}
