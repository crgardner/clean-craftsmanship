package org.crg.kata.poker;

public class StraightFlushClassification extends HandClassification {
    public StraightFlushClassification(Cards cards) {
        super(cards);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playStraightFlush(cards());
    }

    @Override
    Result playStraightFlush(Cards opponentCards) {
        return determineResult(opponentCards);
    }
}
