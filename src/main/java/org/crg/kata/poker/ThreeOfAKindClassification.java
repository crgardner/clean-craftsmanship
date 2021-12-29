package org.crg.kata.poker;

public class ThreeOfAKindClassification extends HandClassification {
    public ThreeOfAKindClassification(Cards cards) {
        super(cards);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playThreeOfAKind(this);
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
    Result playFlush(HandClassification opponentHand) {
        return opponentWins();
    }

    @Override
    Result playStraight(HandClassification opponentHand) {
        return opponentWins();
    }

    @Override
    Result playThreeOfAKind(HandClassification opponentHand) {
        return cards().threeOfOneCardRank() < opponentHand.cards().threeOfOneCardRank() ?
                opponentWins() : opponentLoses();
    }
}
