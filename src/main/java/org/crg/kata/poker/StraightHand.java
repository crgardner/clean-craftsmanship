package org.crg.kata.poker;

class StraightHand extends HandClassification {

    StraightHand(int[] cardValues) {
        super(cardValues);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playStraightHand(cardValues());
    }

    @Override
    Result playStraightHand(int[] otherCardValues) {
        return determineResult(otherCardValues);
    }

}
