package training.collectionsClass.queue;

import java.util.Arrays;
import java.util.List;

public class Card implements Comparable<Card> {

    public enum Suit {SPADES, HEARTS, CLUBS, DIAMONDS}

    public enum Face {DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

    private final Suit suit;
    private final Face face;

    public Card(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card card) {
        Face[] values = Face.values();
        List<Face> faces = Arrays.asList(values);

        return (faces.indexOf(this.getFace()) != faces.indexOf(card.getFace()))
                ? (faces.indexOf(this.getFace()) > faces.indexOf(card.getFace()) ? 1 : -1)
                : String.valueOf(this.getSuit()).compareTo(String.valueOf(card.getSuit()));
           }

    @Override
    public String toString() {
        return face + " of " + suit;
    }
}
