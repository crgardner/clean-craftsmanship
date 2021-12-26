package org.crg.kata.poker;

class StraightHandClassification extends HandClassification {

    StraightHandClassification(int[] cardValues) {
        super(cardValues);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playStraightHand(cardValues());
    }

    @Override
    Result playFourOfAKind(int[] otherCardValues) {
        return Result.WIN;
    }
    
    @Override
    Result playStraightHand(int[] otherCardValues) {
        return determineResult(otherCardValues);
    }

}
