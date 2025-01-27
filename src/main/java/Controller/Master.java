package Controller;

import Model.*;
import View.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Master {
        private final Menu menu;
        private final GameHandler gameHandler;
        private boolean giocoAttivo;
        private final Player player;
        private final MazeGenerator mazeGen;
        private Room[][] maze;
    
        public Master() {
            this.menu = new Menu();
            this.gameHandler = new GameHandler();
            this.giocoAttivo = true;
            this.player = new Player();
            this.mazeGen = new MazeGenerator();
        }
    
        public void avvia() {
            while (giocoAttivo) {
                int scelta = menu.mostraMenuPrincipale();
    
                switch (scelta) {
                    case 1 -> {
                        GameDifficulty difficolta = menu.scegliDifficolta();
                        giocoAttivo = false;
                        gameHandler.nuovaPartita(difficolta , mazeGen , player);
                       
                    }
                    case 2 -> gameHandler.caricaPartita();
                    case 3 -> {
                        giocoAttivo = false;
                        menu.mostraMessaggio("Grazie per aver giocato a Twilight Heroes! Alla prossima!");
                        giocoAttivo = false;
                    }
                    default -> menu.mostraMessaggio("Opzione non valida. Riprova.");
                }
            }
        }
         

        public void displayCurrentRoom() {
            System.out.println(player.getPostition().getName());
            System.out.println(player.getPostition().getDescription());
        }

 
        public void Game() throws IOException {
            maze = mazeGen.getMaze();

           

            
            List<Consumables> consumables = ConsumableFactory.loadConsumables("src/main/java/consumable.txt");
            List<Weapon> weapons = ItemFactory.loadWeapons("src/main/java/weapon.txt");
            List<Armor> armors = ItemFactory.loadArmor("src/main/java/armor.txt");
            List<Monster> monsters = MonsterFactory.loadMonster("src/main/java/monster.txt");
            System.out.print(maze[1][0].getName());
            MapPopulator.populateMapWithMOnster(maze, monsters);
            MapPopulator.populateMap(maze, consumables);
            MapPopulator.populateMapWithArmor(maze, armors);
            MapPopulator.populateMapWithWeapons(maze, weapons);
            player.setPosition(maze[1][0]);
            printMaze();
            System.out.println(player.getPostition().getName());
            System.out.println(player.getPostition().getPositionX());
            System.out.println(player.getPostition().getPositionY());
            System.out.println("\nBenvenuto, " + player.getName());
            Scanner scanner = new Scanner(System.in);
                boolean gameRunning = true;
                displayCurrentRoom();
                while (gameRunning) {
                    /* 
                    if (!currentRoom.getMonsters().isEmpty()) {
                        Model.Monster monster = currentRoom.getMonsters().get(0);
                        System.out.println("C'è un mostro qui: " + monster.getName() + "!");
                        boolean won = player.fight(monster);
                        if (!won) {
                            System.out.println("Hai perso. Fine del gioco.");
                            gameRunning = false;
                            continue;
                        }
                        currentRoom.getMonsters().remove(monster); // Rimuovi il mostro sconfitto
                    }*/
                    
                    System.out.println("\nCosa vuoi fare?");
                    System.out.println("1. Muoviti");
                    System.out.println("2. Esamina la stanza");
                    System.out.println("3. Controlla l'inventario");
                    System.out.println("4. Controlla lo status del personaggio");
                    System.out.println("5. Esci dal gioco");
                    
                    String action = scanner.nextLine();
                    
                    switch (action) {
                        case "1" -> // Movimento
                            movePlayer(scanner);
                        case "2" -> // Esamina la stanza
                            examineRoom(player.getPostition());
                        case "3" -> // Controlla inventario
                            checkInventory();
                        case "4" -> 
                            checkStatusPg();
                        case "5" -> {
                            // Esci
                            System.out.println("Hai lasciato il gioco.");
                            gameRunning = false;
                        }
                        default -> System.out.println("Azione non valida. Riprova.");
                    }
                    
                    //if (isVictory()) {
                        //System.out.println("Congratulazioni! Hai raggiunto l'uscita e vinto il gioco!");
                        //gameRunning = false;
                    //}
                } 
            }
    

   
    private void movePlayer(Scanner scanner) {
        System.out.println("Usa W (su), A (sinistra), S (giù), D (destra) per muoverti.");
      
    
        String action = scanner.nextLine().toLowerCase(); // Legge il comando dell'utente
        int currentX = player.getPostition().getPositionX();
        int currentY = player.getPostition().getPositionY();
    
        int newX = currentX, newY = currentY; // Nuove coordinate
    
        switch (action) {
            case "w" -> newX = currentX - 1; // Su
            case "a" -> newY = currentY - 1; // Sinistra
            case "s" -> newX = currentX + 1; // Giù
            case "d" -> newY = currentY + 1; // Destra
            default -> {
                System.out.println("Comando non valido. Usa W, A, S o D.");
                return;
            }
        }
    
        // Controlla se la nuova posizione è valida
        if (newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[0].length && maze[newX][newY] != null) {
            player.setPosition(maze[newX][newY]);
            System.out.println("Ti sei spostato nella stanza: " + maze[newX][newY].getName());
            System.out.println(maze[newX][newY].getDescription());
        } else {
            System.out.println("Non puoi muoverti in quella direzione! Prova un'altra direzione.");
        }
        printMaze();
    }

    private List<Room> getAdjacentRooms(Room currentRoom) {
        List<Room> adjacentRooms = new ArrayList<>();
        int x = currentRoom.getPositionX();
        int y = currentRoom.getPositionY();
    
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Su, Giù, Sinistra, Destra
    
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
    
            // Controlla che gli indici siano dentro i confini della matrice
            if (newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[0].length) {
                if (maze[newX][newY] != null) {
                    adjacentRooms.add(maze[newX][newY]);
                }
            }
        }
    
        return adjacentRooms;
    }
    
     

    private void examineRoom(Room currentRoom) {
        System.out.println("Esamini la stanza...");
        if (currentRoom.getConsumables() == null && currentRoom.getWeapon() == null ) { //bisonmga aggiungere qui glki OGGETTI ---------------------------------- CI SONO SOLO I CONSUMABILI
            System.out.println("Non c'e` niente nella stanza.");
        } else if ( currentRoom.getConsumables() != null) {
                System.out.println("Hai trovato: " + currentRoom.getConsumables().toString());
                player.getInventory().addConsumables(currentRoom.getConsumables());
                //player.addItem(item);
            }
            else if (currentRoom.getWeapon() != null){
                System.out.println("Hai trovato: " + currentRoom.getWeapon().toString());
                player.getInventory().addWeapon(currentRoom.getWeapon());
            }
            currentRoom.setConsumables(null); // Rimuovi gli oggetti dalla stanza
        }
    

        private void checkInventory() {
            System.out.println("Inventario:");
        
            // Ottieni l'inventario del giocatore
            List<Consumables> inventoryCons = player.getInventory().getConsumables();
            List<Item> inventoryItem = player.getInventory().getItemList();
            if (inventoryCons.isEmpty() && inventoryItem.isEmpty()) {
                System.out.println("Il tuo inventario è vuoto.");
            } else if (inventoryItem.isEmpty()) {
                // Itera sull'inventario
                System.out.println("-Consuambili:");
                for (Consumables consumables : inventoryCons) {
                    System.out.println("- " + consumables.toString());
                }
            }
            else if(inventoryCons.isEmpty()){
                System.out.println("-Oggetti:");
                for (Item  items : inventoryItem) {
                    System.out.println("- " + items.toString());
                }
            }
            else{
                System.out.println("-Consuambili");
                for (Consumables consumables : inventoryCons) {
                    System.out.println("- " + consumables.toString());
                }
                System.out.println("\n");
                System.out.println("-Oggetti:");
                for (Item  items : inventoryItem) {
                    System.out.println("- " + items.toString());
                }
            }
        }

    private void checkStatusPg() {
       player.getStatus(player);
    }
        private void printMaze(){
            for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (player.getPostition().getPositionX() == i && player.getPostition().getPositionY() == j) {
                    System.out.print("P"); // Indica la posizione del giocatore
                } else if (maze[i][j] == null) {
                    System.out.print("#"); // Muro
                } else {
                    System.out.print(" "); // Spazio percorribile
                }
            }
            System.out.println(); // A capo alla fine di ogni riga
        }
    }
}
/* 
    private boolean isVictory() {
        Model.Room exitRoom = maze.getSize()- 2 + "," + (mazeGenerator.getSize() - 1));
        return player.getX() == exitRoom.getX() && player.getY() == exitRoom.getY();
    }*/


