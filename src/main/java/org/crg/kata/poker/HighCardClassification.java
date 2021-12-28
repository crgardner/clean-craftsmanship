package org.crg.kata.poker;

class HighCardClassification extends HandClassification {

    HighCardClassification(int[] cardValues) {
        super(cardValues);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playHighCardHand(cardValues());
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
    Result playThreeOfAKind(int[] opponentCardValues) {
        return opponentWins();
    }

    @Override
    Result playTwoPairs(int[] opponentCardValues) {
        return opponentWins();
    }

    @Override
    Result playOnePair(int[] opponentCardValues) {
        return opponentWins();
    }

    @Override
    public Result playHighCardHand(int[] opponentCardValues) {
        return determineResult(opponentCardValues);
    }

}
