package OyunProjesi.Locations;

import OyunProjesi.Game.Player;

import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String locName;

    private int id;
    protected Scanner input =new Scanner(System.in);


    public abstract boolean onLocation();

    public Location(int id,Player player,String locName){
        this.player=player;
        this.locName=locName;
        this.id=id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer(){
        return player;
    }
    public void setPlayer(Player player){
        this.player=player;
    }

    public String getLocName(){
        return locName;
    }
    public void setLocName(String locNamee){
        this.locName=locNamee;
    }



}
