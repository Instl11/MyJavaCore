package training.collectionsClass.list;

import training.collectionsClass.queue.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollRunner {
    public static void main(String[] args) {

        LinkedList<Card> cards = new LinkedList<>();
        for (Card.Face face : Card.Face.values()) {
            for (Card.Suit suit : Card.Suit.values())
                cards.add(new Card(suit, face));
        }

        //cards.sort(Card::compareTo);
        //     cards.sort(Comparator.naturalOrder());

        Collections.sort(cards);

        Card queen = new Card(Card.Suit.SPADES, Card.Face.QUEEN);
        int i = Collections.binarySearch(cards, queen);
        if (i >= 0) System.out.println("Card was found at position " + i);
        else System.out.println("Card wasn't found");

        List<Card> cardList = new ArrayList<>(52);
        Collections.fill(cardList, queen);

        /*for (int i = 0; i < cards.size(); i++) {
            System.out.printf("%-20s %s", cards.get(i), (i + 1) % 4 == 0 ? " \n" : "  ");
        }*/



        /*Card card = new Card(Card.Suit.CLUBS, Card.Face.ACE);
        Card card2 = new Card(Card.Suit.CLUBS, Card.Face.THREE);

        System.out.println(card.compareTo(card2));*/


    }


}
