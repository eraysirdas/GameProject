package OyunProjesi.Locations;

import OyunProjesi.Monsters.Zombie;
import OyunProjesi.Game.Player;

public class Cave extends BattleLoc{
    public Cave(Player player) {
        super(1, player, "Mağara", new Zombie(), "food",3);
    }
}
