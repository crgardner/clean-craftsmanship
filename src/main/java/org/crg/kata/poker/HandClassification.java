package org.crg.kata.poker;

abstract class HandClassification {
    public static final int HAND_SIZE = 4;

    private final int[] cardValues;

    HandClassification(int[] cardValues) {
        this.cardValues = cardValues;
    }

    abstract Result play(HandClassification hand);

    Result playStraightHand(int[] cardValues) {  //NOSONAR
        return Result.LOSE;
    }

    Result playTwoPairs(@SuppressWarnings("unused") int[] cardValues) { //NOSONAR
        return Result.LOSE;
    }

    Result playOnePair(@SuppressWarnings("unused") int[] cardValues) { //NOSONAR
        return Result.LOSE;
    }

    Result playHighCardHand(int[] cardValues) { //NOSONAR
        return Result.LOSE;
    }

    protected Result determineResult(int[] otherCardValues) {
        return doDetermineResult(otherCardValues, HAND_SIZE);
    }

    private Result doDetermineResult(int[] otherCardValues, int topCardPosition) {
        if (topCardPosition < 0) {
            return Result.TIE;
        }

        if (cardValues[topCardPosition] > otherCardValues[topCardPosition]) {
            return Result.LOSE;
        }

        if (cardValues[topCardPosition] == otherCardValues[topCardPosition]) {
            return doDetermineResult(otherCardValues, topCardPosition - 1);
        }

        return Result.WIN;
    }

    protected int[] cardValues() {
        return cardValues;
    }
}
