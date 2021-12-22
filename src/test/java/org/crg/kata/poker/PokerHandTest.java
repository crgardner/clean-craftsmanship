package org.crg.kata.poker;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.*;

import static org.crg.kata.poker.Result.*;

/**
 * https://www.codewars.com/kata/ranking-poker-hands/csharp
 * https://en.wikipedia.org/wiki/Texas_hold_%27em
 * https://www.cardplayer.com/rules-of-poker/hand-rankings
 * https://poker.com/learn-poker/winning-poker-hands-poker-hand-rankings/
 *
 * https://www.pokernews.com/poker-hands.htm
 * https://www.dummies.com/article/home-auto-hobbies/games/card-games/general-card-games/how-to-rank-poker-hands-194175
 * https://www.liveabout.com/poker-hands-what-beats-what-537514
 */
@DisplayName("PokerHand")
class PokerHandTest {

    private PokerHand firstHand;
    private PokerHand secondHand;
    private Result result;

    @Nested
    @DisplayName("Straight")
    class Straights {

        @BeforeEach
        void init() {
            secondHand = new PokerHand("3C 4D 5S 6H 7C");
        }

        @Test
        @DisplayName("ties another straight with same high card")
        void tiesAnotherStraightWithSameHighCard() {
            firstHand = new PokerHand("3S 4H 5D 6C 7S");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(TIE);
        }

        @Test
        @DisplayName("beats lower ranked straight")
        void beatsLowerRankedStraight() {
            firstHand = new PokerHand("4S 5H 6D 7C 8S");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("loses to higher ranked straight")
        void losesToHigherRankedStraight() {
            firstHand = new PokerHand("2C 3D 4S 5H 6C");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(LOSE);
        }

        @Test
        @DisplayName("beats high card hand")
        void beatsHighCardHand() {
            firstHand = new PokerHand("2C 3D 4S 5H 6C");
            secondHand = new PokerHand("2H 4D 8D QC KC");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("beats one pair hand")
        void beatsOnePairHand() {
            firstHand = new PokerHand("2C 3D 4S 5H 6C");
            secondHand = new PokerHand("2D 6H 7D 10H 10D");

            var result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }
    }

    @Nested
    @DisplayName("High card")
    class HighCards {
        @Test
        @DisplayName("beats another high card with lower rank")
        void beatsAnotherHighCardWithLowerRank() {
            firstHand = new PokerHand("2H 4D 8D QC AC");
            secondHand = new PokerHand("2H 4D 8D QC KC");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("beats another high card with second high card of lower rank")
        void beatsAnotherHighCardWithSecondHighCardOfLowerRank() {
            firstHand = new PokerHand("2H 4D 8D QC AC");
            secondHand = new PokerHand("2H 5D 8D JC AC");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("loses to straight")
        void losesToStraight() {
            firstHand = new PokerHand("2H 4D 8D QC KC");
            secondHand = new PokerHand("2C 3D 4S 5H 6C");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(LOSE);

        }
    }

    @Nested
    @DisplayName("One pair")
    class OnePair {

        @Test
        @DisplayName("ties one pair of same rank")
        void tiesOnePairOfSameRank() {
            firstHand = new PokerHand("2H 6D 7H 10C 10S");
            secondHand = new PokerHand("2D 6H 7D 10H 10D");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(TIE);
        }

        @Test
        @DisplayName("beats high card hand")
        void beatsHighCardHand() {
            firstHand = new PokerHand("2H 6D 7H 10C 10S");
            secondHand = new PokerHand("2H 5D 8D JC AC");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }


    }

}
