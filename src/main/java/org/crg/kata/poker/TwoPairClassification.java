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
    Result playFourOfAKind(Cards opponentCards) {
        return opponentWins();
    }

    @Override
    Result playFullHouse(Cards opponentCards) {
        return opponentWins();
    }

    @Override
    Result playThreeOfAKind(Cards opponentCards) {
        return opponentWins();
    }

    @Override
    Result playTwoPairs(int[] opponentCardValues) {
        return determinePairResult(opponentCardValues);
    }

    private Result determinePairResult(int[] opponentCardValues) {
        if (lowestPair() > lowestPair(opponentCardValues)) {
            return opponentLoses();
        }

        if (lowestPair() < lowestPair(opponentCardValues)) {
            return opponentWins();
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
