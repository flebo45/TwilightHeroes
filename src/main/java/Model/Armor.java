package Model;

public class Armor extends Item {
    private String set;
    private int stat;
    private String statEnch;
    private String part;

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public String getStatsEnch() {
        return statEnch;
    }

    public void setStatsEnch(String statsEnch) {
        this.statEnch = statsEnch;
    }

    public Armor(String name, String description, String set, String part, int stat, String statEnch){
        this.set = set;
        this.statEnch = statEnch;
        this.stat = stat;
        this.name = name;
        this.description = description;
        this.part = part;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

}
