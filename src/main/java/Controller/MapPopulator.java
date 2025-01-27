package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MapPopulator {

    public static void populateMap(Room[][] maze, List<Consumables> consumables) {
        Random random = new Random();
        

        // Calcoliamo il numero massimo di stanze da popolare (ad esempio 40% delle stanze)
        int maxItems = (int) (maze.length * maze.length * 0.3);

        for (int i = 0; i < maxItems; i++) {
            // Scegli un oggetto casuale dalla lista
            Consumables consumable = consumables.get(random.nextInt(consumables.size()));

            boolean placed = false;
            while (!placed) {
                // Scegli una stanza casuale
                int x = random.nextInt(maze.length);
                int y = random.nextInt(maze.length);

                Room room = maze[x][y];
                if(room == null){}
                    else{
                        if (room.getConsumables() == null) { // Verifica che la stanza sia vuota
                            room.setConsumables(consumable);
                            placed = true;
                        }
                }
            }
        }
    }
    public static void populateMapWithWeapons(Room[][] maze, List<Weapon> weapons) {
   
        int size = maze.length; // Supponiamo che la mappa sia quadrata
    
        // Mescola la lista delle armi per randomizzazione
        Collections.shuffle(weapons);

        // Lista per tracciare le stanze da popolare
        List<int[]> availableRooms = new ArrayList<>();

        // Aggiungi tutte le coordinate delle stanze disponibili
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                availableRooms.add(new int[]{i, j});
            }
        }

        // Mescola le stanze per randomizzazione
        Collections.shuffle(availableRooms);

        // Popola la mappa con armi
        int weaponIndex = 0;
        for (int[] roomCoord : availableRooms) {
            if (weaponIndex >= weapons.size()) break;

            int x = roomCoord[0];
            int y = roomCoord[1];

            Room room = maze[x][y];
            if (room != null && room.getWeapon() == null) {
                room.setWeapon(weapons.get(weaponIndex));
                weaponIndex++;
            }
        }

        System.out.println("Mappa popolata con armi.");
    }
    
    public static void populateMapWithArmor(Room[][] maze, List<Armor> armors) {
   
        int size = maze.length; // Supponiamo che la mappa sia quadrata
    
        // Mescola la lista delle armi per randomizzazione
        Collections.shuffle(armors);

        // Lista per tracciare le stanze da popolare
        List<int[]> availableRooms = new ArrayList<>();

        // Aggiungi tutte le coordinate delle stanze disponibili
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                availableRooms.add(new int[]{i, j});
            }
        }

        // Mescola le stanze per randomizzazione
        Collections.shuffle(availableRooms);

        // Popola la mappa con armi
        int weaponIndex = 0;
        for (int[] roomCoord : availableRooms) {
            if (weaponIndex >= armors.size()) break;

            int x = roomCoord[0];
            int y = roomCoord[1];

            Room room = maze[x][y];
            if (room != null && room.getWeapon() == null) {
                room.setArmor(armors.get(weaponIndex));
                weaponIndex++;
            }
        }

        System.out.println("Mappa popolata con armature.");
    }

    
    public static void populateMapWithMOnster(Room[][] maze, List<Monster> monsters) {
   
        int size = maze.length; // Supponiamo che la mappa sia quadrata
    
        // Mescola la lista delle armi per randomizzazione
        Collections.shuffle(monsters);

        // Lista per tracciare le stanze da popolare
        List<int[]> availableRooms = new ArrayList<>();

        // Aggiungi tutte le coordinate delle stanze disponibili
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                availableRooms.add(new int[]{i, j});
            }
        }

        // Mescola le stanze per randomizzazione
        Collections.shuffle(availableRooms);

        // Popola la mappa con armi
        int monsterIndex = 0;
        for (int[] roomCoord : availableRooms) {
            if (monsterIndex >= monsters.size()) break;

            int x = roomCoord[0];
            int y = roomCoord[1];

            Room room = maze[x][y];
            if (room != null && room.getWeapon() == null) {
                room.setMonster(monsters.get(monsterIndex));
                monsterIndex++;
            }
        }

        System.out.println("Mappa popolata con armature.");
    }
    
}                                 
