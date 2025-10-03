package academy.hangman;

public class WordSelector {
    private Category category;
    private Difficulty difficulty;
    private boolean randomCategory = false;
    private boolean randomDifficulty = false;

    public Difficulty getDifficulty(){
        return  this.difficulty;
    }
    private WordSelector() {}

    public static WordSelector builder() {
        return new WordSelector();
    }

    public WordSelector withCategory(Category category) {
        this.category = category;
        this.randomCategory = false;
        return this;
    }

    public WordSelector withDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        this.randomDifficulty = false;
        return this;
    }

    public WordSelector withRandomCategory() {
        this.randomCategory = true;
        return this;
    }

    public WordSelector withRandomDifficulty() {
        this.randomDifficulty = true;
        return this;
    }

    public String getWord() {
        Category finalCategory = randomCategory ? LargeMap.getRandomCategory() : category;
        Difficulty finalDifficulty = randomDifficulty ? LargeMap.getRandomDifficulty() : difficulty;
        return LargeMap.getRandomWord(finalCategory, finalDifficulty);
    }
}
