package org.crg.kata.poker;

import java.util.*;
import java.util.stream.Collectors;

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
        var possibleFour = fourOfAKind(cardValues());
        var opponentPossibleFour = fourOfAKind(opponentCardValues);

        if (possibleFour.isEmpty()) {
            return opponentWins();
        }

        if (opponentPossibleFour.isEmpty()) {
            return opponentLoses();
        }

        if (possibleFour.get() > opponentPossibleFour.get()) {
            return opponentLoses();
        }

        return opponentWins();
    }

    private Optional<Integer> fourOfAKind(int[] cardValues) {
        var cardCounts = Arrays.stream(cardValues).boxed()
                               .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return cardCounts.entrySet().stream().filter(c -> c.getValue().equals(4L)).map(Map.Entry::getKey).findFirst();
    }


}
