package academy.hangman;


public enum Category {
    ANIMALS("Животные"),
    FAMILY("Семья"),
    COUNTRIES("Страны"),
    FOOD("Еда"),
    JOBS("Профессии");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
