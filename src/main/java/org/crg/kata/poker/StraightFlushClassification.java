package org.crg.kata.poker;

public class StraightFlushClassification extends HandClassification {
    public StraightFlushClassification(Cards cards) {
        super(cards);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playStraightFlush(this);
    }

    @Override
    Result playStraightFlush(HandClassification opponentHand) {
        return determineResult(opponentHand);
    }
}
