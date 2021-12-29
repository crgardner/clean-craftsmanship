package org.crg.kata.poker;

class StraightClassification extends HandClassification {

    StraightClassification(Cards cards) {
        super(cards);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playStraight(this);
    }

    @Override
    Result playStraightFlush(HandClassification opponentHand) {
        return opponentWins();
    }

    @Override
    Result playFourOfAKind(HandClassification opponentHand) {
        return opponentWins();
    }

    @Override
    Result playFullHouse(HandClassification opponentHand) {
        return opponentWins();
    }

    @Override
    Result playFlush(HandClassification opponentHand) {
        return opponentWins();
    }

    @Override
    Result playStraight(HandClassification opponentHand) {
        return determineResult(opponentHand);
    }

}
