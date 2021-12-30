package org.crg.kata.poker;

class OnePairClassification extends HandClassification {

    OnePairClassification(Cards cards) {
        super(cards);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playOnePair(this);
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
        return opponentWins();
    }

    @Override
    Result playThreeOfAKind(HandClassification opponentHand) {
        return opponentWins();
    }

    @Override
    Result playTwoPair(HandClassification opponentHand) {
        return opponentWins();
    }

    @Override
    Result playOnePair(HandClassification opponentHand) {
        if (cards().lowestPair() < opponentHand.cards().lowestPair()) {
            return opponentWins();
        }

        if (cards().lowestPair() > opponentHand.cards().lowestPair()) {
            return opponentLoses();
        }

        return determineResult(opponentHand);
    }

}
