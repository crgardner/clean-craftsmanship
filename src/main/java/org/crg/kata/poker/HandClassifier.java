package org.crg.kata.poker;

interface HandClassifier {
    HandClassification classify(Cards cards);
}

class StraightFlushClassifier implements HandClassifier {
    private final HandClassifier nextClassifier = new FourOfAKindClassifier();

    @Override
    public HandClassification classify(Cards cards) {
        return isStraightFlush(cards) ? new StraightFlushClassification(cards)
                                      : nextClassifier.classify(cards);
    }

    private boolean isStraightFlush(Cards cards) {
        return cards.isStraight() && cards.hasSameSuit();
    }
}

class FourOfAKindClassifier implements HandClassifier {
    private final HandClassifier nextClassifier = new FullHouseClassifier();

    @Override
    public HandClassification classify(Cards cards) {
        return hasFourOfAKind(cards) ? new FourOfAKindClassification(cards)
                                     : nextClassifier.classify(cards);
    }

    private boolean hasFourOfAKind(Cards cards) {
        return cards.hasFourOfAKind();
    }
}

class FullHouseClassifier implements HandClassifier {
    private final HandClassifier nextClassifier = new FlushClassifier();

    @Override
    public HandClassification classify(Cards cards) {
        return hasFullHouse(cards) ? new FullHouseClassification(cards)
                                   : nextClassifier.classify(cards);
    }

    private boolean hasFullHouse(Cards cards) {
        return cards.hasNumberOfPairs(1) && cards.hasThreeOfAKind();
    }
}

class FlushClassifier implements HandClassifier {
    private final HandClassifier nextClassifier = new StraightClassifier();

    @Override
    public HandClassification classify(Cards cards) {
        return isFlush(cards) ? new FlushClassification(cards)
                              : nextClassifier.classify(cards);
    }

    private boolean isFlush(Cards cards) {
        return cards.hasSameSuit();
    }
}

class StraightClassifier implements HandClassifier {
    private final HandClassifier nextClassifier = new ThreeOfAKindClassifier();

    @Override
    public HandClassification classify(Cards cards) {
        return isStraight(cards) ? new StraightClassification(cards)
                                 : nextClassifier.classify(cards);
    }

    private boolean isStraight(Cards cards) {
       return cards.isStraight();
    }

}

class ThreeOfAKindClassifier implements HandClassifier {
    private final HandClassifier nextClassifier = new PairClassifier();

    @Override
    public HandClassification classify(Cards cards) {
        return isThreeOfAKind(cards) ? new ThreeOfAKindClassification(cards)
                                     : nextClassifier.classify(cards);
    }

    private boolean isThreeOfAKind(Cards cards) {
        return cards.hasThreeOfAKind();
    }
}

class PairClassifier implements HandClassifier {
    private final HandClassifier nextClassifier = new HighCardClassifier();

    @Override
    public HandClassification classify(Cards cards) {
        if (isOnePair(cards)) {
            return new OnePairClassification(cards);
        }

        if (isTwoPair(cards)) {
            return new TwoPairClassification(cards);
        }

        return nextClassifier.classify(cards);
    }

    private boolean isTwoPair(Cards cards) {
        return hasPairs(2, cards);
    }

    private boolean isOnePair(Cards cards) {
        return hasPairs(1, cards);
    }

    private boolean hasPairs(int pairCount, Cards cards) {
        return cards.hasNumberOfPairs(pairCount);
    }
}

class HighCardClassifier implements HandClassifier {

    @Override
    public HandClassification classify(Cards cards) {
        return new HighCardClassification(cards);
    }
}