package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import Model.Room;

public class MazeGenerator {

    private Room[][] maze;
    private int size;
    private Random random;
    private List<Room> roomDescriptions;

    public MazeGenerator() {}

    public void SetSize(int size) {
        this.size = size;
        this.maze = new Room[size][size];
        this.random = new Random();
        this.roomDescriptions = new ArrayList<>();
    }

    public Room[][] getMaze() {
    return maze;
}


    public void generateMaze() {
        // Inizializza il labirinto con muri ovunque
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                maze[i][j] = null; // Muri inizializzati a `null` 
            }
        }
    
        // Genera il percorso principale e diramazioni
        createPath(1, 1);
    
        // Aggiungi l'entrata e l'uscita
        maze[1][0] = new Room("Ingresso Scuro", "L'ingresso del labirinto.");
        maze[1][0].setPositionX(1);
        maze[1][1] = getRandomRoom();
        maze[1][1].setPositionX(1);
        maze[1][1].setPositionY(1);
        maze[size - 2][size-1] = new Room("Uscita", "L'uscita del labirinto.");
        maze[size-2][size-1].setPositionX(size-2);
        maze[size-2][size-1].setPositionY(size-1);
        // Assicura che ci sia sempre un percorso valido
        ensurePath();
    
        // Assegna casualmente le stanze ai percorsi  
        assignRoomDescriptions();
    }
    

    private void createPath(int startX, int startY) {
        Stack<int[]> stack = new Stack<>();
        boolean[][] visited = new boolean[size][size];
        int[] dx = {0, 1, 0, -1}; // Direzioni: su, destra, giù, sinistra
        int[] dy = {1, 0, -1, 0};

        stack.push(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            // Mescola le direzioni per creare un percorso casuale
            List<Integer> directions = Arrays.asList(0, 1, 2, 3);
            Collections.shuffle(directions);

            for (int dir : directions) {
                int nx = x + dx[dir] * 2; // Spostamento di 2 celle
                int ny = y + dy[dir] * 2;

                if (isValid(nx, ny, visited)) {
                    // Rimuovi il muro tra le celle
                    maze[x + dx[dir]][y + dy[dir]] = new Room("", "");
                    maze[nx][ny] = new Room("", "");

                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
    }

    private boolean isValid(int x, int y, boolean[][] visited) {
        return x > 0 && x < size - 1 && y > 0 && y < size - 1 && !visited[x][y];
    }

    public void loadRoomDescriptions(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String name = "";
            String description = "";

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    if (!name.isEmpty() && !description.isEmpty()) {
                        roomDescriptions.add(new Room(name, description));
                    }
                    name = "";
                    description = "";
                } else {
                    if (name.isEmpty()) {
                        name = line.trim();
                    } else {
                        description += line.trim() + " ";
                    }
                }
            }

            if (!name.isEmpty() && !description.isEmpty()) {
                roomDescriptions.add(new Room(name, description));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Room getRandomRoom() {
        if (!roomDescriptions.isEmpty()) {
            return roomDescriptions.remove(random.nextInt(roomDescriptions.size()));
        }
        return new Room("Default Room", "Descrizione predefinita.");
    }

    private void assignRoomDescriptions() {
        List<Room> availableRooms = new ArrayList<>(roomDescriptions);
        Collections.shuffle(availableRooms); // Mescola le stanze per l'assegnazione casuale
        int roomIndex = 0;
        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {
                if (maze[i][j] != null && maze[i][j].getName().isEmpty() && roomIndex < availableRooms.size()) {
                    maze[i][j] = availableRooms.get(roomIndex);
                    maze[i][j].setPositionX(i);
                    maze[i][j].setPositionY(j);
                    roomIndex++;
                }
            }
        }
    }

    private boolean isPathValid() {
        boolean[][] visited = new boolean[size][size];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});
        visited[1][1] = true;
    
        int[] dx = {0, 1, 0, -1}; // Direzioni: su, destra, giù, sinistra
        int[] dy = {1, 0, -1, 0};
    
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
    
            // Controlla se abbiamo raggiunto l'uscita
            if (x == size - 2 && y == size - 2) {
                return true;
            }
    
            // Esplora le celle adiacenti
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
    
                if (nx > 0 && nx < size - 1 && ny > 0 && ny < size - 1 &&
                    maze[nx][ny] != null && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    
        return false; // Nessun percorso trovato
    }


    private void ensurePath() {
        if (!isPathValid()) {
            // Assicurati che (1,2) sia accessibile da (1,1)
            maze[1][2] = new Room("", "");
    
            // Assicurati che (size-2, size-3) e (size-2, size-2) siano collegate
            maze[size - 2][size - 3] = new Room("", "");
            maze[size - 2][size - 2] = new Room("", "");
    
            // Crea un percorso tra (1,2) e (size-2, size-2)
            createPath(1, 2);
        }
    }
    




    public Room getRoom(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            return null; // Posizione non valida
        }
        return maze[x][y];
    }

    public void printMaze() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (maze[i][j] == null) {
                    System.out.print("#"); // Muro
                } else {
                    System.out.print(" "); // Spazio percorribile
                }
            }
            System.out.println(); // A capo alla fine di ogni riga
        }
    }
}
