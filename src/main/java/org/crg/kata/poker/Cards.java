package org.crg.kata.poker;

import java.util.*;
import java.util.stream.*;

class Cards {
    private static final int HAND_SIZE = 4;

    private final int[] cardValues;

    Cards(int... cardValues) {
        this.cardValues = cardValues;
    }

    boolean hasNumberOfPairs(int pairCount) {
        return countCards().values().stream().filter(c -> c.equals(2L)).count() == pairCount;
    }

    private Map<Integer, Long> countCards() {
        return Arrays.stream(cardValues)
                     .boxed()
                     .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    int threeOfOneCardRank() {
        return cardValueWithCount(3L);
    }

    int cardValueWithCount(long cardCount) {
        return countCards().entrySet()
                           .stream()
                           .filter(c -> c.getValue().equals(cardCount))
                           .map(Map.Entry::getKey)
                           .findFirst().orElse(0);
    }

    boolean hasThreeOfOneCardRank() {
        return countCards().values().stream().filter(c -> c.equals(3L)).count() == 1;
    }

    boolean isStraight() {
        return IntStream.range(0, cardValues.length - 1)
                        .map(i -> cardValues[i] - cardValues[i + 1])
                        .allMatch(d -> d == -1);

    }

    boolean hasFourOfAKind() {
        return countCards().values().stream().anyMatch(c -> c.equals(4L));
    }

    int fourOfOneCardRank() {
        return cardValueWithCount(4L);
    }

    Result determineResult(Cards opponentCards) {
        return doDetermineResult(opponentCards.cardValues, HAND_SIZE);
    }

    Result doDetermineResult(int[] opponentCardValues, int topCardPosition) {
        if (topCardPosition < 0) {
            return Result.TIE;
        }

        if (cardValues[topCardPosition] > opponentCardValues[topCardPosition]) {
            return Result.LOSE;
        }

        if (cardValues[topCardPosition] == opponentCardValues[topCardPosition]) {
            return doDetermineResult(opponentCardValues, topCardPosition - 1);
        }

        return Result.WIN;
    }

    int lowestPair() {
        return countCards().entrySet()
                           .stream()
                           .filter(e -> e.getValue().equals(2L))
                           .findFirst()
                           .map(Map.Entry::getKey)
                           .orElse(-1);
    }

    public int[] getCardValues() {
        return cardValues;
    }
}
