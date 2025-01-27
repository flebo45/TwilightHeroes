package Model;


public class Weapon extends Item{
    private String AttackP;
    private String AttackS;
    private int dmgP;
    private int dmgS;

    public String getAttackP() {
        return AttackP;
    }

    public void setAttackP(String AttackP) {
        this.AttackP = AttackP;
    }

    public String getAttackS() {
        return AttackS;
    }

    public void setAttackS(String AttackS) {
        this.AttackS = AttackS;
    }

    public int getDmgP() {
        return dmgP;
    }

    public void setDmgP(int dmgP) {
        this.dmgP = dmgP;
    }

    public int getDmgS() {
        return dmgS;
    }

    public void setDmgS(int dmgS) {
        this.dmgS = dmgS;
    }

    public Weapon( String name, String  description, String attackP, String  attackS, int dmgP, int dmgS){
        this.name = name;
        this.description = description;
        this.AttackP = attackP;
        this.AttackS = attackS;
        this.dmgP = dmgP;
        this.dmgS = dmgS;

    }
}