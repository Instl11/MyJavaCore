package training.collectionsClass.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueLauncher {
    public static void main(String[] args) {

        Queue<Card> cardDeck = new PriorityQueue<>(new CardComparator());

        for (Card.Face face : Card.Face.values()){
            for (Card.Suit suit : Card.Suit.values()){
                cardDeck.offer(new Card(suit, face));
            }
        }

        int i = (int) "vishal".charAt(0);
        System.out.println(i);
        int ind = 115 & (16-1);
        System.out.println(ind);


    }
}
