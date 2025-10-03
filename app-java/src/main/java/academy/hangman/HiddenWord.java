package academy.hangman;


import java.util.Arrays;
import java.util.Map;

public class HiddenWord {
    public int length;


    private final Cell[] cells;
    private final Cell[] hiddenWord;

    public HiddenWord(String word) {
        this.length = word.length();
        this.cells = new Cell[this.length];
        this.hiddenWord = Cell.fromString(word);
        Arrays.fill(this.cells, Cell.EMPTY);
    }



    public Ends makeMove(final String symbol) {
        if (!isValid(symbol)) {
            return Ends.ERROR;
        }
        boolean flag = false;
        for(int i = 0;i< hiddenWord.length; i++ ){
            if(Cell.fromString(symbol)[0] == hiddenWord[i] ){
                flag = true;
                cells[i] = hiddenWord[i];
                length-=1;
            }
        }
        return flag? Ends.SUCCESS: Ends.LOSE;
    }

    public boolean isValid(final String symbol) {
        return (Cell.fromString(symbol)[0] != Cell.EMPTY);

    }

    public String toString() {
        return Cell.toString(cells);
    }
}
