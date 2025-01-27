package View;

import Model.GameDifficulty;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public int mostraMenuPrincipale() {
        System.out.println("|=== TWILIGHT HEROES ===|");
        System.out.println("|1. Nuova Partita       |");
        System.out.println("|2. Carica Partita      |");
        System.out.println("|3. Esci                |");
        System.out.println("|=======================|");
        System.out.print("Seleziona un'opzione:    ");
        return scanner.nextInt();
    }

    public GameDifficulty scegliDifficolta() {
        System.out.println("\n|=== Seleziona la Difficoltà ===|");
        System.out.println("|1. Facile                      |");
        System.out.println("|2. Normale                     |");
        System.out.println("|3. Difficile                   |");
        System.out.print("Inserisci il numero della difficoltà: ");

        int scelta = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline

        switch (scelta) {
            case 1:
                return GameDifficulty.EASY;
            case 2:
                return GameDifficulty.NORMAL;
            case 3:
                return GameDifficulty.HARD;
            default:
                System.out.println("Opzione non valida. Impostata difficoltà predefinita: Normale.");
                return GameDifficulty.NORMAL;
        }
    }

    public void mostraMessaggio(String messaggio) {
        System.out.println(messaggio);
    }
}