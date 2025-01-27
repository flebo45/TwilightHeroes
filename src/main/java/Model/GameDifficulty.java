package Model;

public enum GameDifficulty {
    EASY("hai selezionato la modalità Facile"),
    NORMAL("hai selezionato la modalità Normale"),
    HARD("hai selezionato la modalità Difficile");

    private final String description;

    GameDifficulty(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}