package org.crg.kata.poker;

abstract class HandClassification {
    public static final int HAND_SIZE = 4;

    private final int[] cardValues;

    HandClassification(int[] cardValues) {
        this.cardValues = cardValues;
    }

    abstract Result play(HandClassification hand);

    Result playFourOfAKind(int[] opponentCardValues) { //NOSONAR
        return opponentLoses();
    }

    Result playFullHouse(int[] opponentCardValues) { //NOSONAR
        return opponentLoses();
    }

    Result playStraightHand(int[] opponentCardValues) {  //NOSONAR
        return opponentLoses();
    }

    Result playTwoPairs(int[] opponentCardValues) { //NOSONAR
        return opponentLoses();
    }

    Result playOnePair(int[] opponentCardValues) { //NOSONAR
        return opponentLoses();
    }

    Result playHighCardHand(int[] opponentCardValues) { //NOSONAR
        return opponentLoses();
    }

    protected Result determineResult(int[] opponentCardValues) {
        return doDetermineResult(opponentCardValues, HAND_SIZE);
    }

    private Result doDetermineResult(int[] opponentCardValues, int topCardPosition) {
        if (topCardPosition < 0) {
            return opponentTies();
        }

        if (cardValues[topCardPosition] > opponentCardValues[topCardPosition]) {
            return opponentLoses();
        }

        if (cardValues[topCardPosition] == opponentCardValues[topCardPosition]) {
            return doDetermineResult(opponentCardValues, topCardPosition - 1);
        }

        return opponentWins();
    }

    protected int[] cardValues() {
        return cardValues;
    }

    protected Result opponentWins() {
        return Result.WIN;
    }

    protected Result opponentLoses() {
        return Result.LOSE;
    }

    protected Result opponentTies() {
        return Result.TIE;
    }

}
