package OyunProjesi.Monsters;

public class Obstacle {
    private int obsId;
    private String obsName;
    private int obsDamage;
    private int obsHealth;
    private int obsAward;
    private int orjObsHealth;

    public Obstacle(int obsId, String obsName, int obsDamage, int obsHealth,int obsAward) {
        this.obsId = obsId;
        this.obsName = obsName;
        this.obsDamage = obsDamage;
        this.obsHealth = obsHealth;
        this.obsAward=obsAward;
        this.orjObsHealth=obsHealth;
    }

    public int getOrjObsHealth() {
        return orjObsHealth;
    }

    public void setOrjObsHealth(int orjObsHealth) {
        this.orjObsHealth = orjObsHealth;
    }

    public int getObsAward() {
        return obsAward;
    }

    public void setObsAward(int obsAward) {
        this.obsAward = obsAward;
    }

    public int getObsId() {
        return obsId;
    }

    public void setObsId(int obsId) {
        this.obsId = obsId;
    }

    public String getObsName() {
        return obsName;
    }

    public void setObsName(String obsName) {
        this.obsName = obsName;
    }

    public int getObsDamage() {
        return obsDamage;
    }

    public void setObsDamage(int obsDamage) {
        this.obsDamage = obsDamage;
    }

    public int getObsHealth() {
        return obsHealth;
    }

    public void setObsHealth(int obsHealth) {
        if(obsHealth<0){
            obsHealth=0;
        }
        this.obsHealth = obsHealth;
    }
}
