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
    Result playStraightHand(int[] otherCardValues) {
        return Result.WIN;
    }

    @Override
    Result playTwoPairs(int[] otherCardValues) {
        return Result.WIN;
    }

    @Override
    Result playOnePair(int[] otherCardValues) {
        return determineResult(otherCardValues);
    }

}
