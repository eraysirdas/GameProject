package OyunProjesi.Locations;

import OyunProjesi.Game.Player;

public abstract class NormalLoc extends Location {

    public NormalLoc(int id, Player player, String locName) {
        super(id,player, locName);
    }
    @Override
    public boolean onLocation(){
        return true;
    }


}
