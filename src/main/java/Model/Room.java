package Model;

public class Room {
    String name;
    String description;
    int positionX;
    int positionY;
    Consumables consumables;
    Weapon weapon;
    Armor armor;
    Monster monster;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public int getPositionX(){
        return positionX;
    }
    public int getPositionY(){
        return positionY;
    }
    public void setPositionX(int position){
         this.positionX = position;
        }

    public void setPositionY(int position){
        this.positionY = position;
    }

    public Consumables getConsumables() {
        return consumables;
    }

    public void setConsumables(Consumables consumables) {
        this.consumables = consumables;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Armor getArmor() {
        return armor;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
    
}