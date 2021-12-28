package org.crg.kata.poker;

public class ThreeOfAKindClassification extends HandClassification {
    public ThreeOfAKindClassification(int[] cardValues) {
        super(cardValues);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playThreeOfAKind(cards());
    }

    @Override
    Result playThreeOfAKind(Cards opponentCards) {
        return cards().threeOfOneCardRank() < opponentCards.threeOfOneCardRank() ?
                opponentWins() : opponentLoses();
    }
}
