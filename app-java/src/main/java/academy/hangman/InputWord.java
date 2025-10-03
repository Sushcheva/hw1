package academy.hangman;

import java.util.Arrays;
import java.util.Map;

public class InputWord implements Word, Position {
    private static final Map<Cell, Character> SYMBOLS = Map.of(
            Cell.X,
            Cell.O,
    );
    private int m;
    private int n;
    private int k;
    private int a;
    private int b;
    private int empty;
    private int number;

    private final Cell[][] cells;
    private Cell turn;

    public TicTacToeBoard(int m, int n, int k) {
        this.cells = new Cell[m][n];
        this.m = m;
        this.n = n;
        this.k = k;
        this.empty = m * n;
        this.a = -m % 2;
        this.b = -n % 2;
        for (Cell[] row : cells) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
        this.number = this.empty;
    }

    public TicTacToeBoard(int n, int k) {
        this.m = 2 * (n) - 1;
        this.n = 1 + 2 * (n - 1);
        this.cells = new Cell[m][this.n];
        this.k = k;
        this.empty = m * this.n;
        this.a = -this.m % 2;
        this.b = -this.n % 2;
        for (Cell[] row : cells) {
            Arrays.fill(row, Cell.E);
        }
        int spaceCounter = 1;
        for (int i = n; i < this.m; i++) {
            for (int j = 0; j < spaceCounter; j++) {
                cells[i][j] = Cell.W;
                cells[i][2 * (n - 1) - j] = Cell.W;
                cells[this.m - 1 - i][j] = Cell.W;
                cells[this.m - 1 - i][2 * (n - 1) - j] = Cell.W;
                this.empty -= 4;
            }
            spaceCounter += 1;
        }
        System.err.println(this.empty);
        this.number = this.empty;
        turn = Cell.X;
    }

    @Override
    public Position getPosition() {
        return this;
    }

    @Override
    public Cell getCell() {
        return turn;
    }

    @Override
    public Result makeMove(final Move move) {
        if (!isValid(move)) {
            return Result.LOSE;
        }

    }

    @Override
    public boolean isValid(final Move move) {


        int i = (this.number) - this.empty + 1;
        return (row <= (m - 1) / 2 + (a + 2 * i) / 2 && row >= (m - 1) / 2 - (a + 2 * i) / 2 && row < m && row >= 0)
                && (column <= (n - 1) / 2 + (b + 2 * i) / 2 && column >= (n - 1) / 2 - (b + 2 * i) / 2 && column < n && column >= 0)
                && cells[row][column] == Cell.E
                && turn == getCell();
    }

    @Override
    public Cell getCell(final int r, final int c) {
        return cells[r][c];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("  ");

        return sb.toString();
    }
}
