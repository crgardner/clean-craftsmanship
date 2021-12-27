package org.crg.kata.poker;

import java.util.*;
import java.util.stream.*;

public class Cards {
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
        return countCards().entrySet().stream().filter(c -> c.getValue().equals(3L)).map(Map.Entry::getKey)
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

}
