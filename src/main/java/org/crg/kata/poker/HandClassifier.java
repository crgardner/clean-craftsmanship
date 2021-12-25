package org.crg.kata.poker;

import java.util.*;
import java.util.stream.*;

interface HandClassifier {
    HandClassification classify(int[] cardValues);
}

class StraightHandClassifier implements HandClassifier {
    private final HandClassifier nextClassifier = new PairClassifier();

    @Override
    public HandClassification classify(int[] cardValues) {
        if (isStraight(cardValues)) {
            return new StraightHand(cardValues);
        }
        return nextClassifier.classify(cardValues);
    }

    private boolean isStraight(int[] cardValues) {
        return IntStream.range(0, cardValues.length - 1)
                        .map(i -> cardValues[i] - cardValues[i + 1])
                        .allMatch(d -> d == -1);
    }

}

class PairClassifier implements HandClassifier {
    private final HandClassifier nextClassifier = new HighCardClassifier();

    @Override
    public HandClassification classify(int[] cardValues) {
        if (isOnePair(cardValues)) {
            return new OnePairClassification(cardValues);
        }

        if (isTwoPair(cardValues)) {
            return new TwoPairClassification(cardValues);
        }

        return nextClassifier.classify(cardValues);
    }

    private boolean isTwoPair(int[] cardValues) {
        return hasPairs(2, cardValues);

    }

    private boolean isOnePair(int[] cardValues) {
        return hasPairs(1, cardValues);
    }

    private boolean hasPairs(int pairCount, int[] cardValues) {
        var cardCounts = Arrays.stream(cardValues).boxed()
                               .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return cardCounts.values().stream().filter(c -> c.equals(2L)).count() == pairCount;
    }
}

class HighCardClassifier implements HandClassifier {

    @Override
    public HandClassification classify(int[] cardValues) {
        return new HighCardClassification(cardValues);
    }
}