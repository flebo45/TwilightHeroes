package Model;

public abstract class Consumables {
    protected String name;
    protected String description;


    public Consumables(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Metodo astratto che ogni consumabile implementerà
    public abstract void consume(Player player);

    @Override
    public String toString() {
        return name + ", " + description;
    }

}
