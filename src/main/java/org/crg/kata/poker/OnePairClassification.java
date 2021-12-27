package org.crg.kata.poker;

class OnePairClassification extends HandClassification {

    OnePairClassification(int[] cardValues) {
        super(cardValues);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playOnePair(cardValues());
    }

    @Override
    Result playFourOfAKind(int[] opponentCardValues) {
        return opponentWins();
    }

    @Override
    Result playFullHouse(int[] opponentCardValues) {
        return opponentWins();
    }

    @Override
    Result playStraightHand(int[] opponentCardValues) {
        return opponentWins();
    }

    @Override
    Result playTwoPairs(int[] opponentCardValues) {
        return opponentWins();
    }

    @Override
    Result playOnePair(int[] opponentCardValues) {
        return determineResult(opponentCardValues);
    }

}