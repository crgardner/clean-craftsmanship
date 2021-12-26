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
    @DisplayName("Four of a kind")
    class FourOfAKind {
        @Test
        @DisplayName("beats straight hand")
        void beatsStraightHand() {
            firstHand = new PokerHand("9H 9C 9D 9S KH");
            secondHand = new PokerHand("3C 4D 5S 6H 7C");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("beats two pair hand")
        void beatsTwoPairHand() {
            firstHand = new PokerHand("9H 9C 9D 9S KH");
            secondHand = new PokerHand("2C 2D 4C 4D 5C");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("beats one pair hand")
        void beatsOnePairHand() {
            firstHand = new PokerHand("9H 9C 9D 9S KH");
            secondHand = new PokerHand("2C 2D 3C 4D 5C");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("beats high card hand")
        void beatsHighCardHand() {
            firstHand = new PokerHand("9H 9C 9D 9S KH");
            secondHand = new PokerHand("2C 4D 6C 8D AC");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("beats lower ranked four of a kind")
        void beatsLowerRankedFourOfAKind() {
            firstHand = new PokerHand("9H 9C 9D 9S AH");
            secondHand = new PokerHand("4C 4D 4S 4H KC");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("loses to higher ranked four of a kind")
        void losesToHigherRankedFourOfAKind() {
            firstHand = new PokerHand("4C 4D 4S 4H KC");
            secondHand = new PokerHand("9H 9C 9D 9S AH");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(LOSE);
        }
    }

    @Nested
    @DisplayName("Straight")
    class Straight {

        @BeforeEach
        void init() {
            secondHand = new PokerHand("3C 4D 5S 6H 7C");
        }

        @Test
        @DisplayName("ties another straight hand with same high card")
        void tiesAnotherStraightWithSameHighCard() {
            firstHand = new PokerHand("3S 4H 5D 6C 7S");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(TIE);
        }

        @Test
        @DisplayName("beats lower ranked straight hand")
        void beatsLowerRankedStraight() {
            firstHand = new PokerHand("4S 5H 6D 7C 8S");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("loses to higher ranked straight hand")
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

        @Test
        @DisplayName("loses to four of a kind")
        void losesToFourOfAKind() {
            firstHand = new PokerHand("3C 4D 5S 6H 7C");
            secondHand = new PokerHand("9H 9C 9D 9S KH");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(LOSE);
        }
    }

    @Nested
    @DisplayName("Two pairs")
    class TwoPairs {

        @Test
        @DisplayName("loses to four of a kind hand")
        void losesToFourOfAKindHand() {
            firstHand = new PokerHand("2C 2D 4C 4D AC");
            secondHand = new PokerHand("3C 3D 3H 3S 5C");

            var result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(LOSE);
        }

        @Test
        @DisplayName("loses to straight hand")
        void losesToStraightHand() {
            firstHand = new PokerHand("2C 2D 4C 4D 5C");
            secondHand = new PokerHand("3C 4D 5S 6H 7C");

            var result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(LOSE);
        }

        @Test
        @DisplayName("ties same ranked two pair hand with same remaining cards")
        void tiesSameRankedTwoPairHandWithSameRemainingCards() {
            firstHand = new PokerHand("2C 2D 4C 4D 5C");
            secondHand = new PokerHand("2H 2S 4H 4S 5H");

            var result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(TIE);
        }

        @Test
        @DisplayName("beats two pair hand with same high pair but lower ranked low pair")
        void beatsTwoPairHandWithSameHighPairButLowerRankedLowPair() {
            firstHand = new PokerHand("3C 3D 4C 4D 5C");
            secondHand = new PokerHand("2H 2S 4H 4S 6H");

            var result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("beats lower ranked two pair hand")
        void beatsLowerRankedTwoPairHand() {
            firstHand = new PokerHand("2C 2D 5C 5D 7C");
            secondHand = new PokerHand("2H 2S 4H 4S 7H");

            var result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("loses to higher ranked two pair hand")
        void losesToHigherRankedTwoPairHand() {
            firstHand = new PokerHand("2C 2D 5C 5D 7C");
            secondHand = new PokerHand("3H 3S 5H 5S 7H");

            var result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(LOSE);
        }

        @Test
        @DisplayName("loses to same ranked two pair hand with higher ranked remaining card")
        void losesToSameRankedTwoPairHandWithHigherRankedRemainingCard() {
            firstHand = new PokerHand("2C 2D 4C 4D 5C");
            secondHand = new PokerHand("2H 2S 4H 4S 6H");

            var result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(LOSE);
        }

        @Test
        @DisplayName("beats one pair hand")
        void beatsOnePairHand() {
            firstHand = new PokerHand("2C 2D 4C 4D 5C");
            secondHand = new PokerHand("2D 6H 7D 10H 10D");

            var result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("beats high card hand")
        void beatsHighCardHand() {
            firstHand = new PokerHand("2C 2D 4C 4D 5C");
            secondHand = new PokerHand("2H 5D 8D JC AC");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }
    }

    @Nested
    @DisplayName("One pair")
    class OnePair {
        @Test
        @DisplayName("loses to four of a kind hand")
        void losesToFourOfAKindHand() {
            firstHand = new PokerHand("2H 6D 7H 10C 10S");
            secondHand = new PokerHand("9H 9C 9D 9S KH");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(LOSE);
        }
        @Test
        @DisplayName("loses to straight hand")
        void losesToStraightHand() {
            firstHand = new PokerHand("2H 6D 7H 10C 10S");
            secondHand = new PokerHand("2D 3H 4D 5H 6D");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(LOSE);
        }

        @Test
        @DisplayName("loses to two pair hand")
        void losesToTwoPairHand() {
            firstHand = new PokerHand("2H 6D 7H 10C 10S");
            secondHand = new PokerHand("3D 3H 4D 4H 6D");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(LOSE);
        }

        @Test
        @DisplayName("ties same ranked one pair hand")
        void tiesSameRankedOnePair() {
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

    @Nested
    @DisplayName("High card")
    class HighCard {
        @Test
        @DisplayName("loses to four of kind hand")
        void losesToFourOfAKindHand() {
            firstHand = new PokerHand("2H 4D 8D QC KC");
            secondHand = new PokerHand("9H 9C 9D 9S QH");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(LOSE);
        }

        @Test
        @DisplayName("loses to straight hand")
        void losesToStraightHand() {
            firstHand = new PokerHand("2H 4D 8D QC KC");
            secondHand = new PokerHand("2C 3D 4S 5H 6C");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(LOSE);

        }

        @Test
        @DisplayName("loses to two pairs hand")
        void losesToTwoPairsHand() {
            firstHand = new PokerHand("2H 4D 8D QC KC");
            secondHand = new PokerHand("2H 2S 4H 4S 5H");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(LOSE);
        }

        @Test
        @DisplayName("loses to one pair hand")
        void losesToOnePairHand() {
            firstHand = new PokerHand("2H 4D 8D QC KC");
            secondHand = new PokerHand("2H 6D 7H 10C 10S");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(LOSE);
        }

        @Test
        @DisplayName("beats lower ranked high card hand")
        void beatsLowerRankedHighCardHand() {
            firstHand = new PokerHand("2H 4D 8D QC AC");
            secondHand = new PokerHand("2H 4D 8D QC KC");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("beats high card hand with lower ranked second high card")
        void beatsHighCardWithLowerRankedSecondHighCard() {
            firstHand = new PokerHand("2H 4D 8D QC AC");
            secondHand = new PokerHand("2H 5D 8D JC AC");

            result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

    }


}
