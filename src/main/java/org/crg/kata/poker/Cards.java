package org.crg.kata.poker;

import java.util.*;
import java.util.stream.*;

public class Cards {
    private static final int HAND_SIZE = 4;

    private final int[] cardValues;

    public Cards(int... cardValues) {
        this.cardValues = cardValues;
    }

    public boolean hasNumberOfPairs(int pairCount) {
        return countCards().values().stream().filter(c -> c.equals(2L)).count() == pairCount;
    }

    private Map<Integer, Long> countCards() {
        return Arrays.stream(cardValues)
                     .boxed()
                     .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    public int threeOfOneCardRank() {
        return cardValueWithCount(3L);
    }

    private Integer cardValueWithCount(long cardCount) {
        return countCards().entrySet().stream().filter(c -> c.getValue().equals(cardCount)).map(Map.Entry::getKey)
                           .findFirst().orElse(0);
    }

    public boolean hasThreeOfOneCardRank() {
        return countCards().values().stream().filter(c -> c.equals(3L)).count() == 1;
    }

    public boolean isStraight() {
        return IntStream.range(0, cardValues.length - 1)
                        .map(i -> cardValues[i] - cardValues[i + 1])
                        .allMatch(d -> d == -1);

    }

    public boolean hasFourOfAKind() {
        return countCards().values().stream().anyMatch(c -> c.equals(4L));
    }

    public int fourOfOneCardRank() {
        return cardValueWithCount(4L);
    }

    public int[] cardValues() {
        return cardValues;
    }

    public Result determineResult(Cards opponentCards) {
        return cdoDetermineResult(opponentCards.cardValues(), HAND_SIZE);
    }

    public Result cdoDetermineResult(int[] opponentCardValues, int topCardPosition) {
        if (topCardPosition < 0) {
            return Result.TIE;
        }

        if (cardValues[topCardPosition] > opponentCardValues[topCardPosition]) {
            return Result.LOSE;
        }

        if (cardValues[topCardPosition] == opponentCardValues[topCardPosition]) {
            return cdoDetermineResult(opponentCardValues, topCardPosition - 1);
        }

        return Result.WIN;
    }
}
