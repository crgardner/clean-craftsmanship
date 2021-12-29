package org.crg.kata.poker;

class OnePairClassification extends HandClassification {

    OnePairClassification(Cards cards) {
        super(cards);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playOnePair(cards());
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
        return determineResult(opponentCards);
    }

}
