package org.crg.kata.poker;

import java.util.*;
import java.util.stream.*;

public class PokerHand {
    private final int[] numericHandValue;

    public PokerHand(String handValue) {
        this.numericHandValue = Stream.of(handValue.replaceAll("[CDHS]", "")
                                                   .replace("J", "11")
                                                   .replace("Q", "12")
                                                   .replace("K", "13")
                                                   .replace("A", "14")
                                                   .split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public Result compareWith(PokerHand secondHand) {
        if (isStraight() && !secondHand.isStraight()) {
            return Result.WIN;
        }

        if (secondHand.isStraight() && !isStraight()) {
            return Result.LOSE;
        }

        if (isTwoPair() && !secondHand.isTwoPair()) {
            return Result.WIN;
        }

        if (isTwoPair() && secondHand.isTwoPair()) {
            return determinePairResult(secondHand);
        }

        if (isOnePair() && !secondHand.isOnePair()) {
            return Result.WIN;
        }

        return determineResult(secondHand, 4);
    }

    private Result determinePairResult(PokerHand secondHand) {
        if (lowestPair() > secondHand.lowestPair()) {
            return Result.WIN;
        }

        if (lowestPair() < secondHand.lowestPair()) {
            return Result.LOSE;
        }

        return determineResult(secondHand, 4);

    }

    private Integer lowestPair() {
        var cardCounts = Arrays.stream(numericHandValue).boxed()
                               .collect(Collectors.groupingBy(c -> c, Collectors.counting()));


        var pair = cardCounts.entrySet().stream().filter(e -> e.getValue().equals(2L)).findFirst().map(Map.Entry::getKey);


        return pair.orElse(-1);
    }

    private boolean isStraight() {
        return IntStream.range(0, numericHandValue.length - 1)
                        .map(i -> numericHandValue[i] - numericHandValue[i + 1])
                        .allMatch(d -> d == -1);
    }

    private boolean isTwoPair() {
        return hasPairs(2);

    }

    private boolean isOnePair() {
        return hasPairs(1);
    }

    private boolean hasPairs(int pairCount) {
        var cardCounts = Arrays.stream(numericHandValue).boxed()
                               .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return cardCounts.values().stream().filter(c -> c.equals(2L)).count() == pairCount;
    }

    private Result determineResult(PokerHand secondHand, int topCardPosition) {
        if (topCardPosition < 0) {
            return Result.TIE;
        }

        if (numericHandValue[topCardPosition] > secondHand.numericHandValue[topCardPosition]) {
            return Result.WIN;
        }

        if (numericHandValue[topCardPosition] == secondHand.numericHandValue[topCardPosition]) {
            return determineResult(secondHand, topCardPosition - 1);
        }

        return Result.LOSE;
    }

}
