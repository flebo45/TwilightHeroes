package Model;

public class Item {
    protected String name;
    protected String description;
    protected boolean equipped;

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

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }
    
    @Override
    public String toString() {
        return name + ", " + description;
    }

 
}

