package org.crg.kata.poker;

abstract class HandClassification {
    private final Cards cards;

    HandClassification(Cards cards) {
        this.cards = cards;
    }

    abstract Result play(HandClassification hand);

    Result playStraightFlush(Cards opponentCards) { //NOSONAR
        return opponentLoses();
    }

    Result playFourOfAKind(Cards opponentCards) { //NOSONAR
        return opponentLoses();
    }

    Result playFlush(Cards opponentCards) { //NOSONAR
        return opponentLoses();
    }

    Result playFullHouse(Cards opponentCards) { //NOSONAR
        return opponentLoses();
    }

    Result playStraight(Cards opponentCards) {  //NOSONAR
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

    Result playHighCard(Cards opponentCards) { //NOSONAR
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
