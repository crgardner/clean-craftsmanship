package org.crg.kata.poker;

public class FullHouseClassification extends HandClassification {
    public FullHouseClassification(int[] cardValues) {
        super(cardValues);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playFullHouse(cards());
    }

    @Override
    Result playFourOfAKind(Cards opponentCards) {
        return opponentWins();
    }

    @Override
    Result playFullHouse(Cards opponentCards) {
        return cards().threeOfOneCardRank() < opponentCards.threeOfOneCardRank() ?
                    opponentWins() : opponentLoses();
    }
}
