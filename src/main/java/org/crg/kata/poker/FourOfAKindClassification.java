package org.crg.kata.poker;

public class FourOfAKindClassification extends HandClassification {
    public FourOfAKindClassification(int[] cardValues) {
        super(cardValues);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playFourOfAKind(cards());
    }

    @Override
    Result playFourOfAKind(Cards opponentCards) {
        return cards().fourOfOneCardRank() < opponentCards.fourOfOneCardRank() ?
                opponentWins() : opponentLoses();

    }

}
