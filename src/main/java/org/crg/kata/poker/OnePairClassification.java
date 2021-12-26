package org.crg.kata.poker;

class OnePairClassification extends HandClassification {

    OnePairClassification(int[] cardValues) {
        super(cardValues);
    }

    @Override
    Result play(HandClassification hand) {
        return hand.playOnePair(cardValues());
    }

    @Override
    Result playFourOfAKind(int[] opponentCardValues) {
        return Result.WIN;
    }

    @Override
    Result playStraightHand(int[] opponentCardValues) {
        return Result.WIN;
    }

    @Override
    Result playTwoPairs(int[] opponentCardValues) {
        return Result.WIN;
    }

    @Override
    Result playOnePair(int[] opponentCardValues) {
        return determineResult(opponentCardValues);
    }

}
