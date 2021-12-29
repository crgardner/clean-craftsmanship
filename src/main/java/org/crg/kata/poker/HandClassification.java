package org.crg.kata.poker;

abstract class HandClassification {
    private final Cards cards;

    HandClassification(Cards cards) {
        this.cards = cards;
    }

    abstract Result play(HandClassification hand);

    Result playStraightFlush(HandClassification opponentHand) { //NOSONAR
        return opponentLoses();
    }

    Result playFourOfAKind(HandClassification opponentHand) { //NOSONAR
        return opponentLoses();
    }

    Result playFlush(HandClassification opponentHand) { //NOSONAR
        return opponentLoses();
    }

    Result playFullHouse(HandClassification opponentHand) { //NOSONAR
        return opponentLoses();
    }

    Result playStraight(HandClassification opponentHand) {  //NOSONAR
        return opponentLoses();
    }

    Result playThreeOfAKind(HandClassification opponentHand) { //NOSONAR
        return opponentLoses();
    }

    Result playTwoPair(HandClassification opponentHand) { //NOSONAR
        return opponentLoses();
    }

    Result playOnePair(HandClassification opponentHand) { //NOSONAR
        return opponentLoses();
    }

    Result playHighCard(HandClassification opponentHand) { //NOSONAR
        return opponentLoses();
    }

    protected Result determineResult(HandClassification opponentHand) {
        return cards.determineResult(opponentHand.cards());
    }

    protected Cards cards() {
        return cards;
    }

    protected Result opponentWins() {
        return Result.WIN;
    }

    protected Result opponentLoses() {
        return Result.LOSE;
    }

}
