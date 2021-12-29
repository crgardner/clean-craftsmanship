package org.crg.kata.poker;

class HighCardClassification extends HandClassification {

    HighCardClassification(Cards cards) {
        super(cards);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playHighCard(this);
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
        return opponentWins();
    }

    @Override
    public Result playHighCard(HandClassification opponentHand) {
        return determineResult(opponentHand);
    }

}
