package org.crg.kata.poker;

class StraightHandClassification extends HandClassification {

    StraightHandClassification(int[] cardValues) {
        super(cardValues);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playStraightHand(cardValues());
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
    Result playStraightHand(int[] opponentCardValues) {
        return determineResult(opponentCardValues);
    }

}
