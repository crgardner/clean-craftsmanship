package org.crg.kata.poker;

class StraightHandClassification extends HandClassification {

    StraightHandClassification(int[] cardValues) {
        super(cardValues);
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
    Result playStraightHand(Cards opponentCards) {
        return determineResult(opponentCards);
    }

}
