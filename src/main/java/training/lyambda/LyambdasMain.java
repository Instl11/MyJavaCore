package training.lyambda;

import java.util.Arrays;
import java.util.Comparator;

public class LyambdasMain {
    public static void main(String[] args) {

        String[] colors = {"green", "red", "blue", "orange", "black", "white"};
        Arrays.sort(colors, Comparator.comparingInt(s -> s.charAt(s.length() - 1))     );

        System.out.println(Arrays.toString(colors));

        Player player1 = new Player("Alex", 100);
        Player player2 = new Player("Igor", 80);
        Player player3 = new Player("Vicktor", 80);
        Player player4 = new Player("John", 91);
        Player[] players = {player1, player2, player3, player4};

        Arrays.sort(players, Comparator.comparingInt(Player::getScore) .thenComparing(Player::getName)       );

        System.out.println(Arrays.toString(players));
    }

    private static class Player {
        private String name;
        private int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
