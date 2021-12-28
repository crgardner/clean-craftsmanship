package org.crg.kata.poker;

class HighCardClassification extends HandClassification {

    HighCardClassification(int[] cardValues) {
        super(cardValues);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playHighCardHand(cards());
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
        return opponentWins();
    }

    @Override
    Result playThreeOfAKind(Cards opponentCards) {
        return opponentWins();
    }

    @Override
    Result playTwoPairs(Cards opponentCards) {
        return opponentWins();
    }

    @Override
    Result playOnePair(Cards opponentCards) {
        return opponentWins();
    }

    @Override
    public Result playHighCardHand(Cards opponentCards) {
        return determineResult(opponentCards);
    }

}
