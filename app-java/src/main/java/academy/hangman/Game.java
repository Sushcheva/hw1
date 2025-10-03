package academy.hangman;


import java.util.HashSet;
import java.util.Set;

public class Game {
    public Result result;
    private final Player player;
    public final HiddenWord hiddenWord;
    private Set<Cell> guesses;
    private Set<Cell> mistakes;

    public Game(String word, Player player, Difficulty hardness) {
        switch (hardness){
            case Difficulty.HARD:
                result = new Result(4);
            case Difficulty.MEDIUM:
                result = new Result(5);
            case Difficulty.EASY:
                result = new Result(7);

        }
        this.hiddenWord = new HiddenWord(word);
        this.player = player;
        this.guesses = new HashSet<>();
        this.mistakes = new HashSet<>();
    }

    public int play() {
        Ends res;
        System.out.println(hiddenWord);
        StringBuilder sb = new StringBuilder("Угаданные буквы:");
        for (Cell symbol : guesses) {
            sb.append(symbol.getSymbol()).append(" ");
        }
        System.out.println(sb);
        sb = new StringBuilder("Буквы, которых нет в слове:");
        for (Cell symbol : mistakes) {
            sb.append(symbol.getSymbol()).append(" ");
        }
        System.out.println(sb);
        while(true){
            String move = player.move();
            while (guesses.contains(Cell.fromString(move)[0]) || mistakes.contains(Cell.fromString(move)[0])){
                System.out.println("Эту буква была уже введена, введите другую");
                move = player.move();
            }
            res = hiddenWord.makeMove(move);
            if (res != Ends.ERROR){
                if(res == Ends.SUCCESS){
                    guesses.add(Cell.fromString(move)[0]);
                } else {
                    mistakes.add(Cell.fromString(move)[0]);
                }
                break;
            }
        }

        if (res == Ends.SUCCESS) {
            return 1;
        } else if (res == Ends.LOSE) {
            result.updateResult();
            System.out.println(result);
            return 0;
        }  return -1;
    }

}
