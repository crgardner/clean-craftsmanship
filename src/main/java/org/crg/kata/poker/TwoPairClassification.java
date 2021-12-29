package org.crg.kata.poker;

class TwoPairClassification extends HandClassification {

    TwoPairClassification(Cards cards) {
       super(cards);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playTwoPairs(cards());
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
        return opponentWins();
    }

    @Override
    Result playThreeOfAKind(Cards opponentCards) {
        return opponentWins();
    }

    @Override
    Result playTwoPairs(Cards opponentCards) {
        if (cards().lowestPair() > opponentCards.lowestPair()) {
            return opponentLoses();
        }

        if (cards().lowestPair() < opponentCards.lowestPair()) {
            return opponentWins();
        }

        return determineResult(opponentCards);

    }

}
