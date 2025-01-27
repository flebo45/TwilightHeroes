package Model;
public class ConsumableSpecial extends Consumables {
    private String effectType;

    public ConsumableSpecial(String name, String description, String effectType) {
        super(name, description);
        this.effectType = effectType;
    }

    @Override
    public void consume(Player player) {
        switch (effectType) {
            case "teleport":
                  // Logica specifica
                System.out.println("Sei stato teletrasportato all'ingresso del dungeon!");
                break;
            case "blind":
                System.out.println("Hai accecato il nemico!");
                // Logica specifica per il nemico
                break;
            case "ress":
              // Logica specifica
                System.out.println("Sei tornato in vita! contninua la tua battaglia");
                break;
            default:
                System.out.println("Effetto speciale non riconosciuto: " + effectType);
        }
           
    }
}
