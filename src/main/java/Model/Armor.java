package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "ARMORS")
public class Armor extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String set;

    @Column(nullable = false)
    private int stat;

    @Column(name = "stat_ench", nullable = true)
    private String statEnch;

    @Column(nullable = false)
    private String part;


    public Armor() {}

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
