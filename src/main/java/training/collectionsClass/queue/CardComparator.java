package training.collectionsClass.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CardComparator implements Comparator<Card> {

    private List<Card.Face> faces = Arrays.asList(Card.Face.values());

    @Override
    public int compare(Card card1, Card card2) {

        if (faces.indexOf(card1.getFace()) == faces.indexOf(card2.getFace()))
            return card2.getSuit().toString().compareTo(card1.getSuit().toString());
        else if (faces.indexOf(card1.getFace()) > faces.indexOf(card2.getFace()))
            return -1;
        else if (faces.indexOf(card1.getFace()) < faces.indexOf(card2.getFace()))
            return 1;
        return 0;
    }
}
