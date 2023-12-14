package OyunProjesi.Game;

import OyunProjesi.Char.Archer;
import OyunProjesi.Char.Knight;
import OyunProjesi.Char.Samurai;

import java.util.Scanner;

public class Player {
    private String charName;
    private String name;
    private int money;
    private int healthy;
    private int orjCharHealth;

    private int damage;
    protected Scanner input =new Scanner(System.in);
    private Inventory inventory;

    public Player(String name){
        this.name =name;
        this.inventory = new Inventory();

    }

    public int getOrjCharHealth() {
        return orjCharHealth;
    }

    public void setOrjCharHealth(int orjCharHealth) {
        this.orjCharHealth = orjCharHealth;
    }
    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getTotalDamage(){
        return damage + getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void selectChar(){
        GameChar[] charlist = {new Samurai(),new Archer(),new Knight()};
        System.out.println("KARAKTERLER");
        System.out.println("-----------------------------------------------------------------------------------------");
        for (GameChar gameChar: charlist) {
            System.out.println("ID : "+gameChar.getId()+
                    "\t\tKarakter : "+gameChar.getName()+
                    "\t\t Hasar : "+gameChar.getDamage()+
                    "\t\t Sağlık : "+gameChar.getHealth()+
                    "\t\t Para : "+gameChar.getMoney());

        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.print("Lütfen bir karakter giriniz : ");
        int selecChar= input.nextInt();

        switch(selecChar){
            case 1:
                initPLayer(new Samurai());
                break;
            case 2:
                initPLayer(new Archer());
                break;
            case 3:
                initPLayer(new Knight());
                break;
            default:
                System.out.println("Var olmayan bir karakter seçtiniz yeniden deneyin");
        }
        System.out.println("Karakter : "+this.getCharName()+
                "\t\t Hasar : "+this.getDamage()+
                "\t\t Sağlık : "+this.getHealthy()+
                "\t\t Para : "+this.getMoney());



        /*Samurai samurai = new Samurai();
        Knight knight = new Knight();
        Archer archer = new Archer();

        System.out.println("Karakter : "+samurai.getName()+samurai.getDamage()+samurai.getHealth()+samurai.getMoney());
        System.out.println("Karakter : "+archer.getName()+archer.getDamage()+archer.getHealth()+archer.getMoney());
        System.out.println("Karakter : "+knight.getName()+knight.getDamage()+knight.getHealth()+knight.getMoney());
        System.out.println(this.charName + " karakteri seçildi !!");

         */
    }




    public void initPLayer(GameChar gameChar){
        this.setCharName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealthy(gameChar.getHealth());
        this.setOrjCharHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
    }

    public void printInfo(){
        System.out.println("Silah : "+this.getInventory().getWeapon().getName()+
                ", Zırh : "+this.getInventory().getArmor().getArmorName()+
                ", Hasar : "+this.getTotalDamage()+
                ", Bloklama : "+this.getInventory().getArmor().getBlock()+
                ", Sağlık : "+this.getHealthy()+
                ", Para : "+this.getMoney());


    }
}

