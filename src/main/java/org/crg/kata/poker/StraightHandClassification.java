package org.crg.kata.poker;

class StraightHandClassification extends HandClassification {

    StraightHandClassification(Cards cards) {
        super(cards);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playStraightHand(cards());
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
    Result playStraightHand(Cards opponentCards) {
        return determineResult(opponentCards);
    }

}
