package Model;

public class Personage {
    protected String name;
    protected int HP;
    protected int STR;
    protected int magic_DEF;
    protected int physic_DEF;
    protected  Room position;
    protected int AGL;

    public Room getPosition() {
        return position;
    }

    public void setPosition(Room position) {
        this.position = position;
    }
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
    public int getAGL() {
        return AGL;
    }

    public void setAGL(int AGL) {
        this.AGL = AGL;
    }

}
