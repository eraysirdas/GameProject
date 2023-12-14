package OyunProjesi.Locations;

import OyunProjesi.Monsters.Vampire;
import OyunProjesi.Game.Player;

public class Forest extends BattleLoc{
    public Forest(Player player) {
        super(2, player, "Orman", new Vampire(), "firewood",3);
    }
}
