package OyunProjesi.Game;

import OyunProjesi.WeaponAndArmor.Armor;
import OyunProjesi.WeaponAndArmor.Weapon;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private String food;
    private String fireWood;
    private String water;

    public Inventory(){

        this.weapon= new Weapon(0,"Yumruk",0,0);
        this.armor = new Armor(0,"Paçavra",0,0);
        this.food=null;
        this.fireWood=null;
        this.water=null;
    }

    
    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFireWood() {
        return fireWood;
    }

    public void setFireWood(String fireWood) {
        this.fireWood = fireWood;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public Armor getArmor(){
        return armor;
    }
    public void setArmor(Armor armor){
        this.armor=armor;
    }

    public Weapon getWeapon(){
        return weapon;
    }
    public void setWeapon(Weapon weapon){
        this.weapon=weapon;
    }
}
