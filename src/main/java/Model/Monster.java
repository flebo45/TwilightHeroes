package Model;

public class Monster {
    private String name;
    private String description;
    private int HP;
    private int STR;
    private int magic_DEF;
    private int physic_DEF;
    private int AGL;
    private int accuracy;

     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDEscription(String description) {
        this.description = description;
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

    public int getAGL() {
        return AGL;
    }

    public void setAGL(int AGL) {
        this.AGL = AGL;
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
