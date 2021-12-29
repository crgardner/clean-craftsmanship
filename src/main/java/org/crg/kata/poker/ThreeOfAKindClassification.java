package org.crg.kata.poker;

public class ThreeOfAKindClassification extends HandClassification {
    public ThreeOfAKindClassification(Cards cards) {
        super(cards);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playThreeOfAKind(cards());
    }

    @Override
    Result playFlush(Cards opponentCards) {
        return opponentWins();
    }

    @Override
    Result playThreeOfAKind(Cards opponentCards) {
        return cards().threeOfOneCardRank() < opponentCards.threeOfOneCardRank() ?
                opponentWins() : opponentLoses();
    }
}
