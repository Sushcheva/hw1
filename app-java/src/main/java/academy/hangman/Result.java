package academy.hangman;

public class Result {
    private int curMistakes = 0;
    public int curStage = 0;
    private int hardness = 1;

    private final int maxMistakes;
    private static String[] stages;


    public Result(int maxWrong) {
        this.maxMistakes = maxWrong;
        this.hardness = 7/maxWrong;
        stages = new String[] {"",
            "  ____\n |    |\n |    \n |    \n |    \n_|_",
            "  ____\n |    |\n |    O\n |    \n |    \n_|_",
            "  ____\n |    |\n |    O\n |    |\n |    \n_|_",
            "  ____\n |    |\n |    O\n |   /|\n |    \n_|_",
            "  ____\n |    |\n |    O\n |   /|\\\n |    \n_|_",
            "  ____\n |    |\n |    O\n |   /|\\\n |   / \n_|_",
            "  ____\n |    |\n |    O\n |   /|\\\n |   / \\\n_|_"};

    }

    public void updateResult(){
        updCurMistakes();
        this.curStage += this.hardness;
        this.curStage = Math.min(this.curStage,7);



    }
    public void updCurMistakes() {
        this.curMistakes++;

    }
    @Override
    public String toString() {
        return stages[curStage];
    }
}
