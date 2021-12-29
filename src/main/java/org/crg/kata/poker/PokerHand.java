package org.crg.kata.poker;

public class PokerHand {
    private final Cards cards;

    public PokerHand(String handValue) {
        cards = new Cards(handValue);
    }

    public Result compareWith(PokerHand opponentHand) {
        var classifier = new StraightFlushClassifier();
        var classifiedHand = classifier.classify(cards);
        var classifiedOpponentHand = classifier.classify(opponentHand.cards);

        return classifiedHand.play(classifiedOpponentHand);
    }

}
