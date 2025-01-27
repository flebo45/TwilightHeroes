package Model;

public class Monster extends Personage {
    private String description;
    private int accuracy;

    
    public String getDescription() {
        return description;
    }

    public void setDEscription(String description) {
        this.description = description;
    }

    public Monster(String name, String description,int hp, int str, int agl, int defF, int defM, int accuracy) {
        this.name = name;
        this.description = description; 
        this.HP = hp;
        this.AGL = agl;
        this.magic_DEF = defM;
        this.physic_DEF = defF;
        this.STR = str;
        this.accuracy = accuracy;
    } 

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
}
