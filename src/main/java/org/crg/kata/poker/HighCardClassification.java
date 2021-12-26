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
        return Result.WIN;
    }

    @Override
    Result playStraightHand(int[] opponentCardValues) {
        return Result.WIN;
    }

    @Override
    Result playTwoPairs(int[] opponentCardValues) {
        return Result.WIN;
    }

    @Override
    Result playOnePair(int[] opponentCardValues) {
        return Result.WIN;
    }

    @Override
    public Result playHighCardHand(int[] opponentCardValues) {
        return determineResult(opponentCardValues);
    }

}
