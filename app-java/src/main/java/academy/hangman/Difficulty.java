package academy.hangman;

public enum Difficulty {
    EASY("Легкий"),
    MEDIUM("Средний"),
    HARD("Сложный");
    private final String displayName;

    Difficulty(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
