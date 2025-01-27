package Controller;

import java.util.Random;
import java.util.Scanner;

import Model.Monster;
import Model.Personage;
import Model.Player;

public class CombatSystem {

    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static boolean  startCombat(Player player, Monster monster) {
        System.out.println("Inizia il combattimento!");
        while (player.getCurrentHP() > 0 && monster.getHP() > 0) {
            System.out.println("\nTurno del giocatore!");
            System.out.println("Scegli l'attacco:");
            System.out.println("1. " + player.getWeapon().getAttackP() + " (Danno: " + player.getWeapon().getDmgP() + ")");
            System.out.println("2. " + player.getWeapon().getAttackS() + " (Danno: " + player.getWeapon().getDmgS()+ ")");

            int choice;
            do {
                System.out.print("Inserisci 1 o 2: ");
                choice = scanner.nextInt();
            } while (choice != 1 && choice != 2);

            // Determina l'iniziativa
            int playerRoll = random.nextInt(20) + 1 + player.getAGL();
            int monsterRoll = random.nextInt(20) + 1 + monster.getAGL();

            System.out.println("\nIniziativa: Giocatore (" + playerRoll + ") vs Mostro (" + monsterRoll + ")");
            boolean playerFirst = playerRoll >= monsterRoll;

            if (playerFirst) {
                performAttack(player, monster);
                if (monster.getHealth() > 0) {
                    performAttack(monster, player, monster.getAttack());
                }
            } else {
                performAttack(monster, player, monster.getAttack());
                if (player.getHealth() > 0) {
                    performAttack(player, monster, playerAttack);
                }
            }

            // Stato attuale
            System.out.println("\nStato attuale:");
            System.out.println("Giocatore - Vita: " + player.getHealth());
            System.out.println("Mostro - Vita: " + monster.getHealth());
        }

        if (player.getHP() <= 0) {
            System.out.println("Il giocatore è stato sconfitto!");
            
        } else {
            System.out.println("Il mostro è stato sconfitto!");
        }
        return false;
    }


    private static void performAttack(Personage attacker, Personage defender) {
        System.out.println(attacker.getName() + " usa " + attacker + "!");
        
        // Determina se l'attacco va a segno
        int hitRoll = random.nextInt(100) + 1;
        if (hitRoll > attack.getAccuracy()) {
            System.out.println(attacker.getName() + " manca il bersaglio!");
            return;
        }

        // Calcolo dei danni
        int damage = attack.getDamage() + attacker.getStrength() - defender.getArmor();
        damage = Math.max(damage, 0); // I danni non possono essere negativi

        System.out.println(attacker.getName() + " infligge " + damage + " danni a " + defender.getName() + "!");
        defender.takeDamage(damage);
    }

}