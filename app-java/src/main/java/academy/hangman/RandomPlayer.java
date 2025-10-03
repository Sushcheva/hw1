package academy.hangman;

import java.util.Random;


public class RandomPlayer implements Player {
    private final Random random;
    private int n;
    private int m;
    public static int counter = 0;
    private String name;

    public RandomPlayer(final Random random) {
        this.random = random;
    }

    public RandomPlayer() {
        this(new Random());
        counter += 1;
        this.name =  "RandomPlayer "+ counter;

    }


    public String move() {
        return Cell.randomLetter().toString();


    }
    public String toString() {
        return(this.name);
    }
}
