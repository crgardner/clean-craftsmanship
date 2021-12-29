package org.crg.kata.poker;

class HighCardClassification extends HandClassification {

    HighCardClassification(Cards cards) {
        super(cards);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playHighCard(cards());
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
        return opponentWins();
    }

    @Override
    Result playOnePair(Cards opponentCards) {
        return opponentWins();
    }

    @Override
    public Result playHighCard(Cards opponentCards) {
        return determineResult(opponentCards);
    }

}
