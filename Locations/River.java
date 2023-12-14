package OyunProjesi.Locations;

import OyunProjesi.Monsters.Bear;
import OyunProjesi.Game.Player;

public class River extends BattleLoc{
    public River(Player player) {
        super(3, player, "Nehir", new Bear(), "water",2);
    }
}
