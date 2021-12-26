package org.crg.kata.poker;

abstract class HandClassification {
    public static final int HAND_SIZE = 4;

    private final int[] cardValues;

    HandClassification(int[] cardValues) {
        this.cardValues = cardValues;
    }

    abstract Result play(HandClassification hand);

    Result playFourOfAKind(int[] opponentCardValues) { //NOSONAR
        return Result.LOSE;
    }

    Result playStraightHand(int[] opponentCardValues) {  //NOSONAR
        return Result.LOSE;
    }

    Result playTwoPairs(int[] opponentCardValues) { //NOSONAR
        return Result.LOSE;
    }

    Result playOnePair(int[] opponentCardValues) { //NOSONAR
        return Result.LOSE;
    }

    Result playHighCardHand(int[] opponentCardValues) { //NOSONAR
        return Result.LOSE;
    }

    protected Result determineResult(int[] opponentCardValues) {
        return doDetermineResult(opponentCardValues, HAND_SIZE);
    }

    protected Result doDetermineResult(int[] opponentCardValues, int topCardPosition) {
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

    protected int[] cardValues() {
        return cardValues;
    }

}
