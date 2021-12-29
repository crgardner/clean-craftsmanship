package org.crg.kata.poker;

import java.util.stream.Stream;

public class PokerHand {
    private final int[] numericHandValue;

    public PokerHand(String handValue) {
        this.numericHandValue = Stream.of(handValue.replaceAll("[CDHS]", "")
                                      .replace("T", "10")
                                      .replace("J", "11")
                                      .replace("Q", "12")
                                      .replace("K", "13")
                                      .replace("A", "14")
                                      .split(" "))
                                      .mapToInt(Integer::parseInt)
                                      .toArray();
    }

    public Result compareWith(PokerHand secondHand) {
        var classifier = new FourOfAKindClassifier();
        var myHand = classifier.classify(new Cards(numericHandValue));
        var yourHand = classifier.classify(new Cards(secondHand.numericHandValue));

        return myHand.play(yourHand);
    }

}
