package Controller;

import Model.GameDifficulty;
import Model.Player;

public class GameHandler {


    public void nuovaPartita(GameDifficulty difficolta, MazeGenerator mazeGenerator, Player player) {

        // Definisci la dimensione del labirinto in base alla difficoltà
        int mazeSize = switch (difficolta) {
            case EASY -> 15;
            case NORMAL -> 20;
            case HARD -> 30;
        };
        mazeGenerator.SetSize(mazeSize);
        // Genera il labirinto
        mazeGenerator.loadRoomDescriptions("src/main/java/room.txt"); // Percorso del file con le descrizioni
        mazeGenerator.generateMaze();

        // Stampa il labirinto per verificare
        //mazeGenerator.printMaze();

        // Puoi aggiungere altre logiche di gioco qui
        System.out.println("Labirinto generato. Buona fortuna!");

        //Genera il giocatore
        System.out.println("con quale nome vuoi essere ricordato avventuriero?");
        player.pgGenerator(player);
    }

    public void caricaPartita() {
        System.out.println("\n=== Carica Partita ===");
        System.out.println("Funzionalità non ancora implementata. Ritorno al menu principale.\n");
    }
}
