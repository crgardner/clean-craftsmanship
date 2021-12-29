package org.crg.kata.poker;

public class FullHouseClassification extends HandClassification {
    public FullHouseClassification(Cards cards) {
        super(cards);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playFullHouse(this);
    }

    @Override
    Result playStraightFlush(HandClassification opponentHand) {
        return opponentWins();
    }

    @Override
    Result playFourOfAKind(HandClassification opponentHand) {
        return opponentWins();
    }

    @Override
    Result playFullHouse(HandClassification opponentHand) {
        return cards().threeOfOneCardRank() < opponentHand.cards().threeOfOneCardRank() ?
                    opponentWins() : opponentLoses();
    }
}
