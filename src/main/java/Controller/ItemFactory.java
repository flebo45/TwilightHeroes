package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Armor;
import Model.Weapon;

public class ItemFactory {

    // Metodo per caricare le armi da un file
    public static List<Weapon> loadWeapons(String filePath) throws IOException {
        List<Weapon> weapons = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            List<String> block = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    // Se il blocco è completo, processalo
                    if (!block.isEmpty()) {
                        Weapon weapon = parseWeapon(block);
                        if (weapon != null) {
                            weapons.add(weapon);
                        }
                        block.clear(); // Resetta il blocco per il prossimo oggetto
                    }
                } else {
                    // Aggiungi la riga al blocco corrente
                    block.add(line);
                }
            }

            // Gestisci l'ultimo blocco se presente
            if (!block.isEmpty()) {
                Weapon weapon = parseWeapon(block);
                if (weapon != null) {
                    weapons.add(weapon);
                }
            }
        }
        return weapons;
    }

    // Metodo per interpretare un blocco di testo come un'arma
    private static Weapon parseWeapon(List<String> block) {
        try {
            if (block.size() < 6) {
                System.out.println("Blocco incompleto o errato: " + block);
                return null;
            }

            String name = block.get(0);
            String description = block.get(1);
            String attackP = block.get(2); // Attacco primario
            String attackS = block.get(3); // Attacco secondario
            int dmgP = Integer.parseInt(block.get(4)); // Danno primario
            int dmgS = Integer.parseInt(block.get(5)); // Danno secondario

            return new Weapon(name, description, attackP, attackS, dmgP, dmgS);
        } catch (NumberFormatException e) {
            System.out.println("Errore nel parsing del danno per il blocco: " + block);
            return null;
        }
    }

    public static List<Armor> loadArmor(String filePath) throws IOException {
        List<Armor> armors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            List<String> block = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    // Se il blocco è completo, processalo
                    if (!block.isEmpty()) {
                        Armor armor = parseArmor(block);
                        if (armor != null) {
                            armors.add(armor);
                        }
                        block.clear(); // Resetta il blocco per il prossimo oggetto
                    }
                } else {
                    // Aggiungi la riga al blocco corrente
                    block.add(line);
                }
            }

            // Gestisci l'ultimo blocco se presente
            if (!block.isEmpty()) {
                Armor armor = parseArmor(block);
                if (armor != null) {
                    armors.add(armor);
                }
            }
        }
        return armors;
    }

    // Metodo per interpretare un blocco di testo come un'arma
    private static Armor parseArmor(List<String> block) {
            if (block.size() < 6) {
                System.out.println("Blocco incompleto o errato: " + block);
                return null;
            }

            String name = block.get(0);
            String description = block.get(1);
            String set = block.get(2); 
            String part = block.get(3); 
            int stat = Integer.parseInt(block.get(4));
            String statEnch = block.get(5);
           

            return new Armor(name, description, set, part, stat, statEnch);
        }
    }


