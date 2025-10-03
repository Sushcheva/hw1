package academy.hangman;

import java.util.Arrays;
import java.util.Random;

public enum Cell {
    A('а'), B('б'), V('в'), G('г'), D('д'), E('е'),
    YO('ё'), ZH('ж'), Z('з'), I('и'), J('й'), K('к'),
    L('л'), M('м'), N('н'), O('о'), P('п'), R('р'),
    S('с'), T('т'), U('у'), F('ф'), H('х'), C('ц'),
    CH('ч'), SH('ш'), SHCH('щ'), Y('ы'), E2('э'),
    U2('ю'), YA('я'),
    EMPTY('_'), X('*');

    private final char symbol;

    Cell(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isLetter() {
        return this != EMPTY;
    }

    public boolean isEmpty() {
        return this == EMPTY;
    }

    public static Cell fromSymbol(char symbol) {
        for (Cell cell : values()) {
            if (cell.symbol == symbol) {
                return cell;
            }
        }
        return EMPTY;
    }

    public static Cell randomLetter() {
        Cell[] letters = Arrays.stream(values())
                .filter(Cell::isLetter)
                .toArray(Cell[]::new);
        Random random = new Random();
        return letters[random.nextInt(letters.length)];
    }

    public static Cell[] fromString(String str) {
        return str.chars()
                .mapToObj(ch -> fromSymbol((char) ch))
                .toArray(Cell[]::new);
    }

    public static String toString(Cell[] cells) {
        StringBuilder sb = new StringBuilder();
        for (Cell cell : cells) {
            sb.append(cell.symbol);
        }
        return sb.toString();
    }
}
