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
    Result playFourOfAKind(int[] opponentCardValues) {
        var cards = new Cards(cardValues());
        var opponentCards = new Cards(opponentCardValues);

        return cards.fourOfOneCardRank() < opponentCards.fourOfOneCardRank() ?
                opponentWins() : opponentLoses();

    }

}
