package org.crg.kata.poker;

public class FullHouseClassification extends HandClassification {
    public FullHouseClassification(int[] cardValues) {
        super(cardValues);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playFullHouse(cardValues());
    }

    @Override
    Result playFourOfAKind(int[] opponentCardValues) {
        return opponentWins();
    }

    @Override
    Result playFullHouse(int[] opponentCardValues) {
        var cards = new Cards(cardValues());
        var opponentCards = new Cards(opponentCardValues);

        return cards.threeOfOneCardRank() < opponentCards.threeOfOneCardRank() ?
                    opponentWins() : opponentLoses();
    }
}
