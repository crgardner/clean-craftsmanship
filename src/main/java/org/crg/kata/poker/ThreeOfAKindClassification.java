package org.crg.kata.poker;

public class ThreeOfAKindClassification extends HandClassification {
    public ThreeOfAKindClassification(int[] cardValues) {
        super(cardValues);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playThreeOfAKind(cardValues());
    }

    @Override
    Result playThreeOfAKind(int[] opponentCardValues) {
        var opponentCards = new Cards(opponentCardValues);

        return cards().threeOfOneCardRank() < opponentCards.threeOfOneCardRank() ?
                opponentWins() : opponentLoses();
    }
}
