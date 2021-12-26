package org.crg.kata.poker;

public class FourOfAKindClassification extends HandClassification {
    public FourOfAKindClassification(int[] cardValues) {
        super(cardValues);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playFourOfAKind(cardValues());
    }

    @Override
    Result playFourOfAKind(int[] cardValues) {
        // this works only if high card is not one of the four. Need to rewrite this.
        return doDetermineResult(cardValues, 3);
    }


}
