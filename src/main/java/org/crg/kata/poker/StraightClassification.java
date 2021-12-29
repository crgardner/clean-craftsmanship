package org.crg.kata.poker;

class StraightClassification extends HandClassification {

    StraightClassification(Cards cards) {
        super(cards);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playStraight(cards());
    }

    @Override
    Result playStraightFlush(Cards opponentCards) {
        return opponentWins();
    }

    @Override
    Result playFourOfAKind(Cards opponentCards) {
        return opponentWins();
    }

    @Override
    Result playFullHouse(Cards opponentCards) {
        return opponentWins();
    }

    @Override
    Result playFlush(Cards opponentCards) {
        return opponentWins();
    }

    @Override
    Result playStraight(Cards opponentCards) {
        return determineResult(opponentCards);
    }

}
