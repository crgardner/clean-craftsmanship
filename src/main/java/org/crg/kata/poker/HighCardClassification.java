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
    Result playStraightHand(int[] cardValues) {
        return Result.WIN;
    }

    @Override
    Result playTwoPairs(int[] cardValues) {
        return Result.WIN;
    }

    @Override
    Result playOnePair(int[] cardValues) {
        return Result.WIN;
    }

    @Override
    public Result playHighCardHand(int[] cardValues) {
        return determineResult(cardValues);
    }

}
