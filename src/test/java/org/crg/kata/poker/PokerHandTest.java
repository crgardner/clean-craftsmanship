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
    @DisplayName("Straight flush")
    class StraightFlush {

        @Test
        @DisplayName("beats four of a kind")
        void beatsFourOfAKind() {
            firstHand = new PokerHand("5H 6H 7H 8H 9H");
            secondHand = new PokerHand("2H 2C 2D 2S AH");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats full house")
        void beatsFullHouse() {
            firstHand = new PokerHand("5H 6H 7H 8H 9H");
            secondHand = new PokerHand("2C 2D TS TH TC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats flush")
        void beatsFlush() {
            firstHand = new PokerHand("5H 6H 7H 8H 9H");
            secondHand = new PokerHand("5C 7C 8C TC KC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats straight")
        void beatsStraight() {
            firstHand = new PokerHand("5H 6H 7H 8H 9H");
            secondHand = new PokerHand("3C 4D 5S 6H 7C");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats three of a kind")
        void beatsThreeOfAKind() {
            firstHand = new PokerHand("5H 6H 7H 8H 9H");
            secondHand = new PokerHand("3C 3H 3D 6H 7D");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats two pair")
        void beatsTwoPair() {
            firstHand = new PokerHand("5H 6H 7H 8H 9H");
            secondHand = new PokerHand("2C 2D 4C 4D 5C");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats one pair")
        void beatsOnePair() {
            firstHand = new PokerHand("5H 6H 7H 8H 9H");
            secondHand = new PokerHand("2C 2D 3C 4D 5C");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats high card")
        void beatsHighCard() {
            firstHand = new PokerHand("5H 6H 7H 8H 9H");
            secondHand = new PokerHand("2C 4D 6C 8D AC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats lower ranked straight flush")
        void beatsLowerRankedStraightFlush() {
            firstHand = new PokerHand("5H 6H 7H 8H 9H");
            secondHand = new PokerHand("4C 5C 6C 7C 8C");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("loses to higher ranked straight flush")
        void losesToHigherRankedStraightFlush() {
            firstHand = new PokerHand("4C 5C 6C 7C 8C");
            secondHand = new PokerHand("5H 6H 7H 8H 9H");

            compareHands();

            assertFirstHandLoses();
        }
    }

    @Nested
    @DisplayName("Four of a kind")
    class FourOfAKind {
        @Test
        @DisplayName("loses to straight flush")
        void losesToStraightFlush() {
            firstHand = new PokerHand("9H 9C 9D 9S AH");
            secondHand = new PokerHand("5H 6H 7H 8H 9H");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("beats full house")
        void beatsFullHouse() {
            firstHand = new PokerHand("9H 9C 9D 9S AH");
            secondHand = new PokerHand("2C 2D TS TH TC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats flush")
        void beatsFlush() {
            firstHand = new PokerHand("9H 9C 9D 9S AH");
            secondHand = new PokerHand("5C 7C 8C TC KC");

            compareHands();

            assertFirstHandWins();
        }


        @Test
        @DisplayName("beats straight")
        void beatsStraight() {
            firstHand = new PokerHand("9H 9C 9D 9S KH");
            secondHand = new PokerHand("3C 4D 5S 6H 7C");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats three of a kind")
        void beatsThreeOfAKind() {
            firstHand = new PokerHand("9H 9C 9D 9S KH");
            secondHand = new PokerHand("3C 3H 3D 6H 7D");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats two pair")
        void beatsTwoPair() {
            firstHand = new PokerHand("9H 9C 9D 9S KH");
            secondHand = new PokerHand("2C 2D 4C 4D 5C");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats one pair")
        void beatsOnePair() {
            firstHand = new PokerHand("9H 9C 9D 9S KH");
            secondHand = new PokerHand("2C 2D 3C 4D 5C");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats high card")
        void beatsHighCard() {
            firstHand = new PokerHand("9H 9C 9D 9S KH");
            secondHand = new PokerHand("2C 4D 6C 8D AC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats lower ranked four of a kind")
        void beatsLowerRankedFourOfAKind() {
            firstHand = new PokerHand("9H 9C 9D 9S AH");
            secondHand = new PokerHand("4C 4D 4S 4H KC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("loses to higher ranked four of a kind")
        void losesToHigherRankedFourOfAKind() {
            firstHand = new PokerHand("4C 4D 4S 4H KC");
            secondHand = new PokerHand("9H 9C 9D 9S AH");

            compareHands();

            assertFirstHandLoses();
        }
    }

    @Nested
    @DisplayName("Full house")
    class FullHouse {
        @Test
        @DisplayName("loses to straight flush")
        void losesToStraightFlush() {
            firstHand = new PokerHand("2C 2D TS TH TC");
            secondHand = new PokerHand("5H 6H 7H 8H 9H");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to four of a kind")
        void losesToFourOfAKind() {
            firstHand = new PokerHand("2C 2D TS TH TC");
            secondHand = new PokerHand("9H 9C 9D 9S AH");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("beats straight")
        void beatsStraight() {
            firstHand = new PokerHand("2C 2D TS TH TC");
            secondHand = new PokerHand("3C 4D 5S 6H 7C");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats two pair")
        void beatsTwoPair() {
            firstHand = new PokerHand("2C 2D TS TH TC");
            secondHand = new PokerHand("2C 2D 4C 4D AC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats one pair")
        void beatsOnePair() {
            firstHand = new PokerHand("2C 2D TS TH TC");
            secondHand = new PokerHand("2H 6D 7H TC TS");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats high card")
        void beatsHighCard() {
            firstHand = new PokerHand("2C 2D TS TH TC");
            secondHand = new PokerHand("2H 4D 8D QC KC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats lower ranked full house")
        void beatsLowerRankedFullHouse() {
            firstHand = new PokerHand("2C 2D TS TH TC");
            secondHand = new PokerHand("2H 2S 9D 9C 9S");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("loses to higher ranked full house")
        void losesToHigherRankedFullHouse() {
            firstHand = new PokerHand("2H 2S 9D 9C 9S");
            secondHand = new PokerHand("2C 2D TS TH TC");

            compareHands();

            assertFirstHandLoses();
        }
    }

    @Nested
    @DisplayName("Flush")
    class Flush {
        @Test
        @DisplayName("loses to four of a kind")
        void losesToFourOfAKind() {
            firstHand = new PokerHand("5C 7C 8C TC KC");
            secondHand = new PokerHand("9H 9C 9D 9S AH");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to full house")
        void losesToFullHouse() {
            firstHand = new PokerHand("5C 7C 8C TC KC");
            secondHand = new PokerHand("2H 2S 9D 9C 9S");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("beats straight")
        void beatsStraight() {
            firstHand = new PokerHand("5C 7C 8C TC KC");
            secondHand = new PokerHand("3C 4D 5S 6H 7C");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats three of a kind")
        void beatsThreeOfAKind() {
            firstHand = new PokerHand("5C 7C 8C TC KC");
            secondHand = new PokerHand("3C 3H 3D 6H 7D");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats two pair")
        void beatsTwoPair() {
            firstHand = new PokerHand("5C 7C 8C TC KC");
            secondHand = new PokerHand("2C 2D 4C 4D AC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats one pair")
        void beatsOnePair() {
            firstHand = new PokerHand("5C 7C 8C TC KC");
            secondHand = new PokerHand("2H 6D 7H TC TS");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats high card")
        void beatsHighCard() {
            firstHand = new PokerHand("5C 7C 8C TC KC");
            secondHand = new PokerHand("2H 4D 8D QC KC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats lower ranked flush")
        void beatsLowerRankedFlush() {
            firstHand = new PokerHand("5C 7C 8C TC KC");
            secondHand = new PokerHand("4D 7D 8D TD KD");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("loses to higher ranked flush")
        void losesToHigherRankedFlush() {
            firstHand = new PokerHand("4D 7D 8D TD KD");
            secondHand = new PokerHand("5C 7C 8C TC KC");

            compareHands();

            assertFirstHandLoses();
        }
    }

    @Nested
    @DisplayName("Straight")
    class Straight {

        @Test
        @DisplayName("loses to straight flush")
        void losesToStraightFlush() {
            firstHand = new PokerHand("3C 4D 5S 6H 7C");
            secondHand = new PokerHand("5H 6H 7H 8H 9H");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to four of a kind")
        void losesToFourOfAKind() {
            firstHand = new PokerHand("3C 4D 5S 6H 7C");
            secondHand = new PokerHand("9H 9C 9D 9S KH");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to full house")
        void losesToFullHouse() {
            firstHand = new PokerHand("3C 4D 5S 6H 7C");
            secondHand = new PokerHand("2C 2D TS TH TC");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to flush")
        void losesToFlush() {
            firstHand = new PokerHand("3C 4D 5S 6H 7C");
            secondHand = new PokerHand("5C 7C 8C TC KC");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("beats three of a kind")
        void beatsThreeOfAKind() {
            firstHand = new PokerHand("3C 4D 5S 6H 7C");
            secondHand = new PokerHand("3C 3H 3D 6H 7D");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats two pair")
        void beatsTwoPair() {
            firstHand = new PokerHand("3C 4D 5S 6H 7C");
            secondHand = new PokerHand("2C 2D 4C 4D AC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats one pair")
        void beatsOnePair() {
            firstHand = new PokerHand("2C 3D 4S 5H 6C");
            secondHand = new PokerHand("2D 6H 7D TH TD");

            var result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("beats high card")
        void beatsHighCard() {
            firstHand = new PokerHand("2C 3D 4S 5H 6C");
            secondHand = new PokerHand("2H 4D 8D QC KC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("ties another straight with same high card")
        void tiesAnotherStraightWithSameHighCard() {
            firstHand = new PokerHand("3S 4H 5D 6C 7S");
            secondHand = new PokerHand("3C 4D 5S 6H 7C");

            compareHands();

            assertThat(result).isEqualTo(TIE);
        }

        @Test
        @DisplayName("beats lower ranked straight")
        void beatsLowerRankedStraight() {
            firstHand = new PokerHand("4S 5H 6D 7C 8S");
            secondHand = new PokerHand("3C 4D 5S 6H 7C");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("loses to higher ranked straight")
        void losesToHigherRankedStraight() {
            firstHand = new PokerHand("2C 3D 4S 5H 6C");
            secondHand = new PokerHand("3C 4D 5S 6H 7C");

            compareHands();

            assertFirstHandLoses();
        }
    }

    @Nested
    @DisplayName("Three of a kind")
    class ThreeOfAKind {
        @Test
        @DisplayName("loses to straight flush")
        void losesToStraightFlush() {
            firstHand = new PokerHand("3C 3H 3D 6H 7D");
            secondHand = new PokerHand("5H 6H 7H 8H 9H");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to four of a kind")
        void losesToFourOfAKind() {
            firstHand = new PokerHand("3C 3H 3D 6H 7D");
            secondHand = new PokerHand("2C 2D TS TH TC");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to full house")
        void losesToFullHouse() {
            firstHand = new PokerHand("3C 3H 3D 6H 7D");
            secondHand = new PokerHand("2C 2D TS TH TC");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to flush")
        void losesToFlush() {
            firstHand = new PokerHand("3C 3H 3D 6H 7D");
            secondHand = new PokerHand("5C 7C 8C TC KC");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to straight")
        void losesToStraight() {
            firstHand = new PokerHand("3C 3H 3D 6H 7D");
            secondHand = new PokerHand("3C 4D 5S 6H 7C");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("beats two pair")
        void beatsTwoPair() {
            firstHand = new PokerHand("3C 3H 3D 6H 7D");
            secondHand = new PokerHand("2C 2D 4C 4D AC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats one pair")
        void beatsOnePair() {
            firstHand = new PokerHand("3C 3H 3D 6H 7D");
            secondHand = new PokerHand("2H 6D 7H TC TS");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats high card")
        void beatsHighCard() {
            firstHand = new PokerHand("3C 3H 3D 6H 7D");
            secondHand = new PokerHand("2H 4D 8D QC KC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats lower ranked three of a kind")
        void beatsLowerRankedThreeOfAKind() {
            firstHand = new PokerHand("3C 3H 3D 6H 7D");
            secondHand = new PokerHand("2H 2D 2D QC KC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("loses to higher ranked three of a kind")
        void losesToHigherRankedThreeOfAKind() {
            firstHand = new PokerHand("2H 2D 2D QC KC");
            secondHand = new PokerHand("3C 3H 3D 6H 7D");

            compareHands();

            assertFirstHandLoses();
        }

    }

    @Nested
    @DisplayName("Two pairs")
    class TwoPair {
        @Test
        @DisplayName("loses to straight flush")
        void losesToStraightFlush() {
            firstHand = new PokerHand("2C 2D 4C 4D AC");
            secondHand = new PokerHand("5H 6H 7H 8H 9H");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to four of a kind")
        void losesToFourOfAKind() {
            firstHand = new PokerHand("2C 2D 4C 4D AC");
            secondHand = new PokerHand("3C 3D 3H 3S 5C");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to full house")
        void losesToFullHouse() {
            firstHand = new PokerHand("2C 2D 4C 4D AC");
            secondHand = new PokerHand("2C 2D TS TH TC");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to flush")
        void losesToFlush() {
            firstHand = new PokerHand("2C 2D 4C 4D AC");
            secondHand = new PokerHand("5C 7C 8C TC KC");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to straight")
        void losesToStraight() {
            firstHand = new PokerHand("2C 2D 4C 4D 5C");
            secondHand = new PokerHand("3C 4D 5S 6H 7C");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to three of a kind")
        void losesToThreeOfAKind() {
            firstHand = new PokerHand("2C 2D 4C 4D 5C");
            secondHand = new PokerHand("3C 3H 3D 6H 7D");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("beats one pair")
        void beatsOnePair() {
            firstHand = new PokerHand("2C 2D 4C 4D 5C");
            secondHand = new PokerHand("2D 6H 7D TH TD");

            var result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(WIN);
        }

        @Test
        @DisplayName("beats high card")
        void beatsHighCard() {
            firstHand = new PokerHand("2C 2D 4C 4D 5C");
            secondHand = new PokerHand("2H 5D 8D JC AC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("ties same ranked two pair with same kicker")
        void tiesSameRankedTwoPairWithSameKicker() {
            firstHand = new PokerHand("2C 2D 4C 4D 5C");
            secondHand = new PokerHand("2H 2S 4H 4S 5H");

            var result = firstHand.compareWith(secondHand);

            assertThat(result).isEqualTo(TIE);
        }

        @Test
        @DisplayName("beats same ranked high pair but lower ranked low pair")
        void beatsSameRankedHighPairButLowerRankedLowPair() {
            firstHand = new PokerHand("3C 3D 4C 4D 5C");
            secondHand = new PokerHand("2H 2S 4H 4S 5H");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats lower ranked high pair")
        void beatsLowerRankedHighPair() {
            firstHand = new PokerHand("2C 2D 5C 5D 7C");
            secondHand = new PokerHand("2H 2S 4H 4S 7H");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("loses same ranked high pair with higher ranked low pair")
        void losesToSameRankedHighPairWithHigherRankedLowPair() {
            firstHand = new PokerHand("2C 2D 5C 5D 7C");
            secondHand = new PokerHand("3H 3S 5H 5S 7H");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses higher ranked high pair")
        void losesToHigherRankedHighPair() {
            firstHand = new PokerHand("2C 2D 5C 5D 7C");
            secondHand = new PokerHand("3H 3S 6H 6S 7H");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to same ranked two pair with higher ranked kicker")
        void losesToSameRankedTwoPairWithHigherRankedKicker() {
            firstHand = new PokerHand("2C 2D 4C 4D 5C");
            secondHand = new PokerHand("2H 2S 4H 4S 6H");

            compareHands();

            assertFirstHandLoses();
        }
    }

    @Nested
    @DisplayName("One pair")
    class OnePair {
        @Test
        @DisplayName("loses to straight flush")
        void losesToStraightFlush() {
            firstHand = new PokerHand("2H 6D 7H TC TS");
            secondHand = new PokerHand("5H 6H 7H 8H 9H");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to four of a kind")
        void losesToFourOfAKind() {
            firstHand = new PokerHand("2H 6D 7H TC TS");
            secondHand = new PokerHand("9H 9C 9D 9S KH");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to full house")
        void losesToFullHouse() {
            firstHand = new PokerHand("2H 6D 7H AC AS");
            secondHand = new PokerHand("2C 2D TS TH TC");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to flush")
        void losesToFlush() {
            firstHand = new PokerHand("2H 6D 7H AC AS");
            secondHand = new PokerHand("5C 7C 8C TC KC");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to straight")
        void losesToStraight() {
            firstHand = new PokerHand("2H 6D 7H TC TS");
            secondHand = new PokerHand("2D 3H 4D 5H 6D");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to three of a kind")
        void losesToThreeOfAKind() {
            firstHand = new PokerHand("2H 6D 7H TC TS");
            secondHand = new PokerHand("3C 3H 3D 6H 7D");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to two pair")
        void losesToTwoPair() {
            firstHand = new PokerHand("2H 6D 7H TC TS");
            secondHand = new PokerHand("3D 3H 4D 4H 6D");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("beats high card")
        void beatsHighCard() {
            firstHand = new PokerHand("2H 6D 7H TC TS");
            secondHand = new PokerHand("2H 5D 8D JC AC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("ties same ranked one pair")
        void tiesSameRankedOnePair() {
            firstHand = new PokerHand("2H 6D 7H TC TS");
            secondHand = new PokerHand("2D 6H 7D TH TD");

            compareHands();

            assertThat(result).isEqualTo(TIE);
        }

        @Test
        @DisplayName("beats lower ranked one pair")
        void beatsLowerRankedOnePair() {
            firstHand = new PokerHand("3H 3D 4H 8C TS");
            secondHand = new PokerHand("2D 2H 7D 9H AD");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("loses to higher ranked one pair")
        void losesToHigherRankedOnePair() {
            firstHand = new PokerHand("2D 2H 7D 9H AD");
            secondHand = new PokerHand("3H 3D 4H 8C TS");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("beats one pair with lower ranked kicker")
        void beatsOnePairWithLowerRankedKicker() {
            firstHand = new PokerHand("3H 3D 4H 8C AS");
            secondHand = new PokerHand("3C 3S 4D 8H TD");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("loses to one pair with higher ranked kicker")
        void losesToOnePairWtihHigherRankedKicker() {
            firstHand = new PokerHand("3C 3S 4D 8H TD");
            secondHand = new PokerHand("3H 3D 4H 8C AS");

            compareHands();

            assertFirstHandLoses();
        }

    }

    @Nested
    @DisplayName("High card")
    class HighCard {
        @Test
        @DisplayName("loses to straight flush")
        void losesToStraightFlush() {
            firstHand = new PokerHand("2H 4D 8D QC KC");
            secondHand = new PokerHand("5H 6H 7H 8H 9H");

            compareHands();

            assertFirstHandLoses();
        }
        @Test
        @DisplayName("loses to four of kind")
        void losesToFourOfAKind() {
            firstHand = new PokerHand("2H 4D 8D QC KC");
            secondHand = new PokerHand("9H 9C 9D 9S QH");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to full house")
        void losesToFullHouse() {
            firstHand = new PokerHand("2H 4D 8D QC KC");
            secondHand = new PokerHand("2C 2D TS TH TC");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to straight")
        void losesToStraight() {
            firstHand = new PokerHand("2H 4D 8D QC KC");
            secondHand = new PokerHand("2C 3D 4S 5H 6C");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to three of a kind")
        void losesToThreeOfAKind() {
            firstHand = new PokerHand("2H 4D 8D QC KC");
            secondHand = new PokerHand("3C 3H 3D 6H 7D");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to two pair")
        void losesToTwoPair() {
            firstHand = new PokerHand("2H 4D 8D QC KC");
            secondHand = new PokerHand("2H 2S 4H 4S 5H");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("loses to one pair")
        void losesToOnePair() {
            firstHand = new PokerHand("2H 4D 8D QC KC");
            secondHand = new PokerHand("2H 6D 7H TC TS");

            compareHands();

            assertFirstHandLoses();
        }

        @Test
        @DisplayName("beats lower ranked high card")
        void beatsLowerRankedHighCard() {
            firstHand = new PokerHand("2H 4D 8D QC AC");
            secondHand = new PokerHand("2H 4D 8D QC KC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("beats high card with lower ranked second high card")
        void beatsHighCardWithLowerRankedSecondHighCard() {
            firstHand = new PokerHand("2H 4D 8D QC AC");
            secondHand = new PokerHand("2H 5D 8D JC AC");

            compareHands();

            assertFirstHandWins();
        }

        @Test
        @DisplayName("loses to higher ranked high card")
        void losesToHigherRankedHighCard() {
            firstHand = new PokerHand("2H 4D 8D QC KC");
            secondHand = new PokerHand("2H 5D 8D JC AC");

            compareHands();

            assertFirstHandLoses();
        }

    }

    private void compareHands() {
        result = firstHand.compareWith(secondHand);
    }

    private void assertFirstHandLoses() {
        assertFirstHand(LOSE);
    }

    private void assertFirstHandWins() {
        assertFirstHand(WIN);
    }

    private void assertFirstHand(Result expectedResult) {
        assertThat(result).isEqualTo(expectedResult);
    }


}
