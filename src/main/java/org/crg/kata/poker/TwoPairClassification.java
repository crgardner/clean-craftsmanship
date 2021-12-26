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
    Result playFourOfAKind(int[] opponentCardValues) {
        return Result.WIN;
    }

    @Override
    Result playTwoPairs(int[] opponentCardValues) {
        return determinePairResult(opponentCardValues);
    }

    private Result determinePairResult(int[] opponentCardValues) {
        if (lowestPair() > lowestPair(opponentCardValues)) {
            return Result.LOSE;
        }

        if (lowestPair() < lowestPair(opponentCardValues)) {
            return Result.WIN;
        }

        return determineResult(opponentCardValues);

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
