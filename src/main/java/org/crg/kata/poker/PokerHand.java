package org.crg.kata.poker;

import java.util.stream.Stream;

public class PokerHand {
    private final Cards cards;

    public PokerHand(String handValue) {
//        boolean hasOneSuit = Stream.of(handValue.replaceAll("[0-9TJQKA]", "").split(" ")).distinct().count() == 1;

        var numericHandValue = Stream.of(handValue.replaceAll("[CDHS]", "")
                                                   .replace("T", "10")
                                                   .replace("J", "11")
                                                   .replace("Q", "12")
                                                   .replace("K", "13")
                                                   .replace("A", "14")
                                                   .split(" "))
                                      .mapToInt(Integer::parseInt)
                                      .toArray();

        cards = new Cards(numericHandValue);
    }

    public Result compareWith(PokerHand secondHand) {
        var classifier = new FourOfAKindClassifier();
        var myHand = classifier.classify(cards);
        var yourHand = classifier.classify(secondHand.cards);

        return myHand.play(yourHand);
    }

}
