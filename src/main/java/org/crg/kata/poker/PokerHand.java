package org.crg.kata.poker;

public class PokerHand {
    private final Cards cards;

    public PokerHand(String handValue) {
        cards = new Cards(handValue);
    }

    public Result compareWith(PokerHand secondHand) {
        var classifier = new FourOfAKindClassifier();
        var myHand = classifier.classify(cards);
        var yourHand = classifier.classify(secondHand.cards);

        return myHand.play(yourHand);
    }

}
