package Model;

public class ConsumableStatus extends Consumables {
    @SuppressWarnings("FieldMayBeFinal")
    private int healthRestored; 
    private int manaRestored;

    public ConsumableStatus(String name, String description, int healthRestored, int manaRestored) {
        super(name, description);
        this.healthRestored = healthRestored;
    }

    @Override
    public void consume(Player player) {
        player.pgHeal(healthRestored, manaRestored);
        if(healthRestored == 0){
        System.out.println("Hai consumato " + name + ". Mana ripristinata di " + manaRestored + " punti.");
        }
        if(manaRestored == 0){
            System.out.println("Hai consumato " + name + ". Hp ripristinata di " + healthRestored+ " punti.");
        }
        else{
            System.out.println("Hai consumato " + name + ". Hp e Mana ripristinati di " +manaRestored + " e " + healthRestored + " punti.");
        }
    }
}