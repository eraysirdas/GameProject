package OyunProjesi.Locations;

import OyunProjesi.Game.GameChar;
import OyunProjesi.Game.Player;

public class SafeHouse extends NormalLoc {
    private GameChar gameChar;

    public SafeHouse(Player player){
        super(1,player,"Güvenli Ev");
    }

    @Override
    public boolean onLocation(){
        System.out.println("Güvenli Evdesiniz !!");
        System.out.println("Eski canınız : "+this.getPlayer().getHealthy());
        System.out.println("Canınız Yenilendi");
        this.getPlayer().setHealthy(this.getPlayer().getOrjCharHealth());
        System.out.println("Yeni canınız : "+this.getPlayer().getHealthy());
        return true;
    }
}
