package Model;

public class ConsumableTime extends Consumables {
    private String effectType;
    private int value;
    private int duration;
    private int statValue;
    private int Statsminus;
    private int StatsPlus;
    private String Stats1 ;
    private String Stats2;


    public ConsumableTime(String name, String description, String effectType, int value, int duration) {
        super(name, description);
        this.effectType = effectType;
        this.value = value;
        this.duration = duration;
        
    }

    @Override
    public void consume(Player player) {
        //player.applyTemporaryEffect(effectType, value, duration);
        System.out.println("Hai consumato " + name + ". Effetto " + effectType + " attivo per " + duration + " turni.");
    }
}
