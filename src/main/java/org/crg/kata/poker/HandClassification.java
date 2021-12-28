package org.crg.kata.poker;

abstract class HandClassification {
    private final Cards cards;

    HandClassification(int[] cardValues) {
        this.cards = new Cards(cardValues);
    }

    abstract Result play(HandClassification hand);

    Result playFourOfAKind(Cards opponentCards) { //NOSONAR
        return opponentLoses();
    }

    Result playFullHouse(Cards opponentCards) { //NOSONAR
        return opponentLoses();
    }

    Result playStraightHand(Cards opponentCards) {  //NOSONAR
        return opponentLoses();
    }

    Result playThreeOfAKind(Cards opponentCards) { //NOSONAR
        return opponentLoses();
    }

    Result playTwoPairs(Cards opponentCards) { //NOSONAR
        return opponentLoses();
    }

    Result playOnePair(Cards opponentCards) { //NOSONAR
        return opponentLoses();
    }

    Result playHighCardHand(Cards opponentCards) { //NOSONAR
        return opponentLoses();
    }

    protected Result determineResult(Cards opponentCards) {
        return cards.determineResult(opponentCards);
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
