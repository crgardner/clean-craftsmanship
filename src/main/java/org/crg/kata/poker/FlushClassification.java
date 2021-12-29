package org.crg.kata.poker;

class FlushClassification extends HandClassification {
    FlushClassification(Cards cards) {
        super(cards);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playFlush(cards());
    }

    @Override
    Result playFlush(Cards opponentCards) {
        return cards().determineResult(opponentCards);
    }
}
