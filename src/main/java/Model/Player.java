package Model;

import java.util.Scanner;

public class Player {
    private String name;
    private int HP;
    private int STR;
    private int magic_DEF;
    private int physic_DEF;
    private int mana;
    private int luck;
    private int AGL;
    private int Money;
    private Armor[] equipment;
    private Weapon weapon;
    private Inventory inventory;
    private Room position;
    private int currentHP;
    private int currentMN; 

    
    public Player() {}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getSTR() {
        return STR;
    }

    public void setSTR(int STR) {
        this.STR = STR;
    }

    public int getMagic_DEF() {
        return magic_DEF;
    }

    public void setMagic_DEF(int magic_DEF) {
        this.magic_DEF = magic_DEF;
    }

    public int getPhysic_DEF() {
        return physic_DEF;
    }

    public void setPhysic_DEF(int physic_DEF) {
        this.physic_DEF = physic_DEF;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getAGL() {
        return AGL;
    }

    public void setAGL(int AGL) {
        this.AGL = AGL;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int Money) {
        this.Money = Money;
    }

    public Armor[] getEquipment() {
        return equipment;
    }

    public void setEquipment(Armor[] equipment) {
        this.equipment = equipment;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
    public void setPosition(Room room) {
        this.position = room;
    }

   public Room getPostition(){
    return position;
   }


    public void pgGenerator(Player player){
        
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);
            // Chiedi il nome del giocatore
            String playerName = scanner.nextLine();
            player.setName(playerName);
            this.inventory = new Inventory();
            // Chiedi la selezione dell'arma (classe)
            System.out.println("\nScegli la tua classe iniziale:");
            System.out.println("1. Guerriero");
            System.out.println("2. Ladro ");
            System.out.println("3. Mago ");
            System.out.println("4. Paladino ");
            System.out.println("5. Ranger ");
            System.out.println("6. Berserker ");
            System.out.println("7. Monaco ");

            
    
            int choice = -1;
            while (choice < 1 || choice > 7) {
                System.out.println("Inserisci un numero valido (1-7):");
                choice = scanner.nextInt();
            }
    
            // Assegna statistiche ed equipaggiamento in base alla scelta
            switch (choice) {
                case 1 -> {
                    // Spada
                    player.setHP(150);  
                    player.setCurrentHP(150);  
                    player.setMana(50);  
                    player.setCurrentMN(50);  
                    player.setSTR(10);  
                    player.setAGL(4);  
                    player.setPhysic_DEF(8);  
                    player.setMagic_DEF(5);  
                    player.setLuck(3);
                    
                    /*da definire come vengono assegnate le armi e le armature
                    player.addItem(new Model.Item("Spada di Ferro", "Un'arma bilanciata per il combattimento ravvicinato."));
                    player.addItem(new Model.Item("Scudo di Legno", "Offre protezione aggiuntiva."));*/
            }
                case 2 -> {
                    // Arco
                    player.setHP(100);  
                    player.setCurrentHP(100);  
                    player.setMana(90);  
                    player.setCurrentMN(90);  
                    player.setSTR(7);  
                    player.setAGL(10);  
                    player.setPhysic_DEF(5);  
                    player.setMagic_DEF(6);  
                    player.setLuck(8);
                    
                    /*da definire come vengono assegnate le armi e le armature
                    player.addItem(new Model.Item("Arco di Legno", "Un'arma agile per il combattimento a distanza."));
                    player.addItem(new Model.Item("Freccia", "Munizioni per l'arco."));*/
            }
                case 3 -> {
                    // Bacchetta magica
                        player.setHP(80);  
                        player.setCurrentHP(80);  
                        player.setMana(200);  
                        player.setCurrentMN(200);  
                        player.setSTR(3);  
                        player.setAGL(5);  
                        player.setPhysic_DEF(3);  
                        player.setMagic_DEF(12);  
                        player.setLuck(6);

                    /*da definire come vengono assegnate le armi e le armature
                    player = new Model.Player(playerName, 80, 8, 5, 30);
                    player.addItem(new Model.Item("Bacchetta Magica", "Perfetta per lanciare incantesimi."));
                    player.addItem(new Model.Item("Libro degli Incantesimi", "Contiene formule magiche."));*/
            }

                    case 4 -> {
                        // Bacchetta magica
                        player.setHP(130);  
                        player.setCurrentHP(130);  
                        player.setMana(100);  
                        player.setCurrentMN(100);  
                        player.setSTR(8);  
                        player.setAGL(5);  
                        player.setPhysic_DEF(10);  
                        player.setMagic_DEF(8);  
                        player.setLuck(4);
                        /*da definire come vengono assegnate le armi e le armature
                        player = new Model.Player(playerName, 80, 8, 5, 30);
                        player.addItem(new Model.Item("Bacchetta Magica", "Perfetta per lanciare incantesimi."));
                        player.addItem(new Model.Item("Libro degli Incantesimi", "Contiene formule magiche."));*/
                }
                    case 5 -> {
                        // Bacchetta magica
                        player.setHP(110);  
                        player.setCurrentHP(110);  
                        player.setMana(70);  
                        player.setCurrentMN(70);  
                        player.setSTR(8);  
                        player.setAGL(9);  
                        player.setPhysic_DEF(6);  
                        player.setMagic_DEF(5);  
                        player.setLuck(7);
                        /*da definire come vengono assegnate le armi e le armature
                        player = new Model.Player(playerName, 80, 8, 5, 30);
                        player.addItem(new Model.Item("Bacchetta Magica", "Perfetta per lanciare incantesimi."));
                        player.addItem(new Model.Item("Libro degli Incantesimi", "Contiene formule magiche."));*/
                }
                    case 6 -> {
                        // Bacchetta magica
                        player.setHP(160);  
                        player.setCurrentHP(160);  
                        player.setMana(30);  
                        player.setCurrentMN(30);  
                        player.setSTR(12);  
                        player.setAGL(6);  
                        player.setPhysic_DEF(7);  
                        player.setMagic_DEF(3);  
                        player.setLuck(5);
                        /*da definire come vengono assegnate le armi e le armature
                        player = new Model.Player(playerName, 80, 8, 5, 30);
                        player.addItem(new Model.Item("Bacchetta Magica", "Perfetta per lanciare incantesimi."));
                        player.addItem(new Model.Item("Libro degli Incantesimi", "Contiene formule magiche."));*/
                }
                    case 7 -> {
                        player.setHP(120);  
                        player.setCurrentHP(120);  
                        player.setMana(100);  
                        player.setCurrentMN(100);  
                        player.setSTR(7);  
                        player.setAGL(8);  
                        player.setPhysic_DEF(8);  
                        player.setMagic_DEF(7);  
                        player.setLuck(6);
                        /*da definire come vengono assegnate le armi e le armature
                        player = new Model.Player(playerName, 80, 8, 5, 30);
                        player.addItem(new Model.Item("Bacchetta Magica", "Perfetta per lanciare incantesimi."));
                        player.addItem(new Model.Item("Libro degli Incantesimi", "Contiene formule magiche."));*/
                    }
            }
        }
    public void pgHeal(int healthRestored, int manaRestored){
        setCurrentHP(healthRestored + getCurrentHP());
        if (getCurrentHP() > getHP()){ setCurrentHP(getHP());}
        setCurrentMN(manaRestored + getCurrentMN());
        if (getCurrentMN() > getMana()){ setCurrentMN(getMana());}
    }

    public int getCurrentMN() {
        return currentMN;
    }

    public void setCurrentMN(int currentMN) {
        this.currentMN = currentMN;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int cuurentHP) {
        this.currentHP = cuurentHP;
    }

    public void getStatus(Player player) {
        System.out.println("Statistiche di:" + player.getName() );
        System.out.println("-HP: " + player.getCurrentHP() + "/" + player.getHP() );
        System.out.println("-Mana: " + player.getCurrentMN() + "/" + player.getMana() );
        System.out.println("-Forza: " + player.getSTR());
        System.out.println("-Agilita`: " + player.getAGL() );
        System.out.println("-Difesa: " + player.getPhysic_DEF());
        System.out.println("- Difesa magica: " + player.getMagic_DEF() );
        System.out.println("-Fortuna: " + player.getLuck() );
        System.out.println("-Monete: " + player.getMoney() );


    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
            }

   



    





