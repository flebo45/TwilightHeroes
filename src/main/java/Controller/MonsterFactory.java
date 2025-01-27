package Controller;

import Model.Monster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class MonsterFactory {
           // Metodo per caricare i consumabili da un file

           public static List<Monster> loadMonster(String filePath) throws IOException {
            List<Monster> monsters = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                List<String> block = new ArrayList<>();
        
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
        
                    if (line.isEmpty()) {
                        // Se il blocco è completo, processalo
                        if (!block.isEmpty()) {
                            Monster monster = parseMonster(block);
                            if (monster != null) {
                                monsters.add(monster);
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
                    Monster monster = parseMonster(block);
                    if (monster != null) {
                        monsters.add(monster);
                    }
                }
            }
            return monsters;
        }
        private static Monster parseMonster(List<String> block) {
            if (block.size() < 3) {
                System.out.println("Blocco incompleto o errato: " + block);
                return null;
            }
            String name = block.get(0);
            String description = block.get(1);
            int health = Integer.parseInt(block.get(2).trim());
            int agl = Integer.parseInt(block.get(3).trim());
            int magicD = Integer.parseInt(block.get(4).trim());
            int physicD = Integer.parseInt(block.get(5).trim());
            int str = Integer.parseInt(block.get(6).trim());
            int accuracy = Integer.parseInt(block.get(7).trim());
            return new Monster(name, description, health, agl, magicD, physicD, str, accuracy);
        }
}
