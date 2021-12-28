package org.crg.kata.poker;

interface HandClassifier {
    HandClassification classify(int[] cardValues);
}

class FourOfAKindClassifier implements HandClassifier {
    private final HandClassifier nextClassifier = new FullHouseClassifier();

    @Override
    public HandClassification classify(int[] cardValues) {
        if (hasFourOfAKind(cardValues)) {
            return new FourOfAKindClassification(cardValues);
        }
        return nextClassifier.classify(cardValues);
    }

    private boolean hasFourOfAKind(int[] cardValues) {
        return new Cards(cardValues).hasFourOfAKind();
    }
}

class FullHouseClassifier implements HandClassifier {
    private final HandClassifier nextClassifier = new StraightHandClassifier();

    @Override
    public HandClassification classify(int[] cardValues) {
        if (hasFullHouse(cardValues)) {
            return new FullHouseClassification(cardValues);
        }
        return nextClassifier.classify(cardValues);
    }

    private boolean hasFullHouse(int[] cardValues) {
        var cards = new Cards(cardValues);

        return cards.hasNumberOfPairs(1) && cards.hasThreeOfOneCardRank();
    }
}

class StraightHandClassifier implements HandClassifier {
    private final HandClassifier nextClassifier = new ThreeOfAKindClassifier();

    @Override
    public HandClassification classify(int[] cardValues) {
        if (isStraight(cardValues)) {
            return new StraightHandClassification(cardValues);
        }
        return nextClassifier.classify(cardValues);
    }

    private boolean isStraight(int[] cardValues) {
       return new Cards(cardValues).isStraight();
    }

}

class ThreeOfAKindClassifier implements HandClassifier {
    private final HandClassifier nextClassifier = new PairClassifier();

    @Override
    public HandClassification classify(int[] cardValues) {
        if (isThreeOfAKind(cardValues)) {
            return new ThreeOfAKindClassification(cardValues);
        }
        return nextClassifier.classify(cardValues);
    }

    private boolean isThreeOfAKind(int[] cardValues) {
        return new Cards(cardValues).hasThreeOfOneCardRank();
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
        return new Cards(cardValues).hasNumberOfPairs(pairCount);
    }
}

class HighCardClassifier implements HandClassifier {

    @Override
    public HandClassification classify(int[] cardValues) {
        return new HighCardClassification(cardValues);
    }
}