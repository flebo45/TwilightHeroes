package Controller;

import Model.ConsumableSpecial;
import Model.ConsumableStatus;
import Model.ConsumableTime;
import Model.Consumables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class ConsumableFactory {
           // Metodo per caricare i consumabili da un file

           public static List<Consumables> loadConsumables(String filePath) throws IOException {
            List<Consumables> consumables = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                List<String> block = new ArrayList<>();
        
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
        
                    if (line.isEmpty()) {
                        // Se il blocco è completo, processalo
                        if (!block.isEmpty()) {
                            Consumables consumable = parseConsumable(block);
                            if (consumable != null) {
                                consumables.add(consumable);
                            }
                            block.clear(); // Resetta il blocco per il prossimo consumabile
                        }
                    } else {
                        // Aggiungi la riga al blocco corrente
                        block.add(line);
                    }
                }
        
                // Gestisci l'ultimo blocco se presente
                if (!block.isEmpty()) {
                    Consumables consumable = parseConsumable(block);
                    if (consumable != null) {
                        consumables.add(consumable);
                    }
                }
            }
            return consumables;
        }
        private static Consumables parseConsumable(List<String> block) {
            if (block.size() < 3) {
                System.out.println("Blocco incompleto o errato: " + block);
                return null;
            }
        
            String name = block.get(0);
            String description = block.get(1);
            String type = block.get(2);
        
            try {
                switch (type) {
                    case "status" -> {
                        int health = Integer.parseInt(block.get(3).trim());
                        int mana = Integer.parseInt(block.get(4).trim());
                        return new ConsumableStatus(name, description, health, mana);
                    }
                    case "time" -> {
                        String effectType = block.get(3).trim();
                        int value = Integer.parseInt(block.get(4).trim());
                        int duration = Integer.parseInt(block.get(5).trim());
                        return new ConsumableTime( name, description, effectType , value, duration);
                    }
                    /*case "immune" -> {
                        return new ConsumableSpecial(name, description, type);
                    }
                    case "magic" -> {
                        String magicType = block.get(3).trim();
                        int damage = Integer.parseInt(block.get(4).trim());
                        return new ConsumableSpecial(name, description, type);
                    }
                    case "teletrasporto" -> {
                        return new ConsumableSpecial(name, description, type);
                    }
                    case "mirror" -> {
                        return new ConsumableSpecial(name, description, type);
                    }
                    case "ress" -> {
                        return new ConsumableSpecial(name, description, type); // Esempio con durata fissa
                    }*/
                    default -> {
                        return new ConsumableSpecial(name, description, type);
                    }
                }
            } catch (Exception e) {
                System.out.println("Errore nel parsing del blocco: " + block + " - " + e.getMessage());
                return null;
            }
        }
    }
        
        
    
        