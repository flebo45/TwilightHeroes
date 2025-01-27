package Model;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> inventoryItem = new ArrayList<>();
    ArrayList<Consumables> inventoryConsumables= new ArrayList<>();
   

    public ArrayList<Item> getItemList() {
        return inventoryItem;

    }

    public void addItemList(Item item) {
        inventoryItem.add(item);
    }

    public ArrayList<Consumables> getConsumables() {
        return inventoryConsumables;
    }

    public void addConsumables(Consumables consumables) {
        inventoryConsumables.add(consumables);
    }
    public void addWeapon(Weapon weapon) {
        inventoryItem.add(weapon);
    }
}
